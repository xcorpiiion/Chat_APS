package cliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import commons.Porta;
import view.Chat;

public class Cliente {

	private boolean running;
	private ServerSocket server;
	
	public Cliente(Chat chat) {
		
		new Thread() {
			@Override
			public void run() {
				setRunning(true);
				try {
					server = new ServerSocket(Porta.getPorta());
					while (isRunning()) {
						Socket connection = server.accept();
						ClienteListerner cl = new ClienteListerner(chat, connection);
						cl.setChatOpen(true);
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
}
