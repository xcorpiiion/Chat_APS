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
		String resposta =null;
		try {
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			if(input.readObject() instanceof String) {
				resposta = (String) input.readObject();
			}
			if(input.readObject() instanceof Mensagem) {
				Mensagem mensagem = (Mensagem) input.readObject();
				MensagensDao.getInstance().create(mensagem);
				resposta = mensagem.toString();
			}
			if(input.readObject() instanceof Anexo) {
				new TransformarArquivo().transformarParaReceber(socket);
				resposta = "ANEXO_ENVIADO";
			}
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resposta;
	}
}
