package cliente;

import java.io.IOException;
import java.net.Socket;

import commons.Acoes;
import view.Chat;

public class ClienteListerner implements Runnable {

	private boolean running;
	private boolean chatOpen;
	private Socket socket;
	private Chat chat;
	private String connectionInfo;

	public ClienteListerner(Chat chat, Socket socket) {
		this.running = false;
		this.chatOpen = false;
		this.socket = socket;
		this.chat = chat;
		this.connectionInfo = null;
	}

	@Override
	public void run() {
		setRunning(true);
		String message;
		while (isRunning()) {
			message = Acoes.receberMensagem(socket);
			chat.mensagens();
			if (message == null || message.equals("CHAT_CLOSE") || !message.equals("ANEXO_ENVIADO")) {
				if (chatOpen) {
					setChatOpen(false);
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					getChat().dispose();
				}
				setRunning(false);
			} else {
				String[] fields = message.split(":");
				if (fields.length > 1) {
					if (fields[0].equals("OPEN CHAT")) {
						String[] splited = fields[1].split(":");
						String connectionInfo = fields[1];
						if (!isChatOpen()) {
							setChatOpen(true);
							setChat(new Chat(socket, connectionInfo));
						}
					}
				}
			}
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isChatOpen() {
		return chatOpen;
	}

	public void setChatOpen(boolean chatOpen) {
		this.chatOpen = chatOpen;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

}
