package cliente;

import java.io.IOException;
import java.net.Socket;

import commons.Acoes;
import controller.ChatController;
import view.Chat;

public class ClienteListerner implements Runnable {

	private boolean running;
	private boolean chatOpen;
	private Socket socket;
	private Chat chat;
	private String connectionInfo;
	private ChatController chatController;

	public ClienteListerner(ChatController chatController,Chat chat, Socket socket) {
		this.running = false;
		this.chatOpen = false;
		this.socket = socket;
		this.chat = chat;
		this.chatController = chatController;
		this.connectionInfo = null;
	}

	public ClienteListerner(ChatController chatController, Socket socket) {
		this.socket = socket;
		this.chatController = chatController;
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
					chatController.getConnectedListerner().remove(connectionInfo);
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
				String[] fields = message.split(";");
				if (fields.length > 1) {
					if (fields[0].equals("OPEN CHAT")) {
						String[] splited = fields[1].split(":");
						String connectionInfo = fields[1];
						if (!isChatOpen()) {
							chatController.getConnectedListerner().put(connectionInfo, this);
							setChatOpen(true);
							setChat(new Chat(chatController,socket, connectionInfo));
						}
					}else {
						getChat().mensagens();
					}
				}
			System.out.println("Mensagem: " + message);
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
