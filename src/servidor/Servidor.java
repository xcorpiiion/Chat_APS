package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import commons.Acoes;

public class Servidor {

	public static final String HOST= "127.0.0.1";
	public static final int PORTA=8080;
	
	private ServerSocket server;
	private Map<String, ClienteListerner> clientes;
	
	public Servidor() {
		try {
			String infoConexao;
			clientes = new HashMap<>();
			server = new ServerSocket(PORTA);
			while(true) {
				Socket socket = server.accept();
				infoConexao = Acoes.receberMensagem(socket);
				if(checkLogin(infoConexao)) {
					ClienteListerner cl = new ClienteListerner(infoConexao, socket, this);
					clientes.put(infoConexao, cl);
					Acoes.enviarMensagem(socket, "SUCESS");
					new Thread(cl).start();
				}else {
					Acoes.enviarMensagem(socket, "Erro");
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkLogin(String infoConexao) {
		String[] splited = infoConexao.split(":");
		for(Map.Entry<String, ClienteListerner> pair : clientes.entrySet()) {
			String[] parts = pair.getKey().split(":");
			if(parts[0].toLowerCase().equals(splited[0].toLowerCase())) {
				return false;
			}else if((parts[1] + parts[2]).equals(splited[1] + splited[2])) {
				return false;
			}
		}
		return true;
	}

	public Map<String, ClienteListerner> getClientes() {
		return clientes;
	}

	public void setClientes(Map<String, ClienteListerner> clientes) {
		this.clientes = clientes;
	}
	
	public static void main(String[] args) {
		 new Servidor();
	}
}
