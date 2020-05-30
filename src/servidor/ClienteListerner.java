package servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import commons.Acoes;

public class ClienteListerner implements Runnable{

	private String infoConexao;
	private Socket socket;
	private Servidor servidor;
	private boolean runnig;

	public ClienteListerner(String infoConexao, Socket socket, Servidor servidor) {
		this.infoConexao = infoConexao;
		this.socket = socket;
		this.servidor = servidor;
		setRunnig(false);
	}

	@Override
	public void run() {
		setRunnig(true);
		String mensagem;
		while(isRunnig()) {
			mensagem = Acoes.receberMensagem(socket);
			if(mensagem.equals("QUIT")) {
				servidor.getClientes().remove(getInfoConexao());
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				setRunnig(false);
			}else if(mensagem.equals("GET_CONNECTED_USERS")) {
				String resposta = "";
				for(Map.Entry<String, ClienteListerner> pair : getServidor().getClientes().entrySet()) {
					System.out.println("Solicitação para atualizar clientes");
					resposta += (pair.getKey() + ";");
				}
				Acoes.enviarMensagem(socket, resposta);
			}else {
				System.out.println(mensagem);
			}
		}
	}

	public String getInfoConexao() {
		return infoConexao;
	}

	public void setInfoConexao(String infoConexao) {
		this.infoConexao = infoConexao;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public boolean isRunnig() {
		return runnig;
	}

	public void setRunnig(boolean runnig) {
		this.runnig = runnig;
	}

}
