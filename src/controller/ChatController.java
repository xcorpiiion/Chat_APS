package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cliente.ClienteListerner;
import commons.Acoes;
import view.Chat;

public class ChatController {

	private boolean running;
	private ServerSocket server;
	private List<String> clientes;
	private Socket socket;
	private String connectionInfo;
	private Map<String, ClienteListerner> connectedListerner;

	public ChatController(Socket socket, String connectionInfo) {
		this.socket = socket;
		this.connectionInfo = connectionInfo;
		this.clientes = new ArrayList<>();
		this.connectedListerner = new HashMap<>();
		startServer(this, Integer.parseInt(connectionInfo.split(":")[2]));
		
	}

	private void getConnectedUsers() {
		Acoes.enviarMensagem(socket, "GET_CONNECTED_USERS");
		String resposta = Acoes.receberMensagem(socket);
		clientes.clear();
		for (String info : resposta.split(";")) {
			if (!info.equals(connectionInfo)) {
				clientes.add(info);
			}
		}
	}

	private void openChat() {
		for (String connectionInfo : clientes) {
			String[] splited = connectionInfo.split(":");
			try {
				Socket socket = new Socket(splited[1], Integer.parseInt(splited[2]));
				Acoes.enviarMensagem(socket, "OPEN CHAT:" + this.connectionInfo);
				ClienteListerner cl = new ClienteListerner(this, socket);
				cl.setChat(new Chat(this, socket, connectionInfo));
				cl.setChatOpen(true);
				connectedListerner.put(connectionInfo, cl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void startServer(ChatController chatController, int porta) {
		this.socket = socket;
		new Thread() {
			@Override
			public void run() {
				setRunning(true);
				try {
					server = new ServerSocket(porta);
					System.out.println("Servidor iniciado na porta " + porta);
					while (isRunning()) {
						Socket connection = server.accept();
						ClienteListerner cl = new ClienteListerner(chatController, connection);
						new Thread(cl).start();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public String getConnectionInfo() {
		return connectionInfo;
	}

	public void setConnectionInfo(String connectionInfo) {
		this.connectionInfo = connectionInfo;
	}

	public Map<String, ClienteListerner> getConnectedListerner() {
		return connectedListerner;
	}

}
