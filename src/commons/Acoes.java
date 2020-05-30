package commons;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import dao.MensagensDao;
import model.Mensagem;
import view.Anexo;

public class Acoes {

	public static boolean enviarMensagem(Socket socket, Object mensagem) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.flush();
			output.writeObject(mensagem);
			output.reset();
			return true;
		} catch (IOException e) {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException ex) {
			}
			e.printStackTrace();
		}
		return false;
	}

	public static String receberMensagem(Socket socket) {
		try {
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			if (input.readObject() instanceof Mensagem) {
				Mensagem mensagem = (Mensagem) input.readObject();
				MensagensDao.getInstance().create(mensagem);
				return mensagem.toString();
			} else if (input.readObject() instanceof Anexo) {
				new TransformarArquivo().transformarParaReceber(socket);
				return "ANEXO_ENVIADO";
			} else if (input.readObject() instanceof String) {
				return (String) input.readObject();
			} else {
				return null;
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close() {
		System.exit(0);
	}
}
