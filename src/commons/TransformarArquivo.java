package commons;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.Arquivo;

public class TransformarArquivo {

	private final long TAMANHO_PERMITIDO = 5120;

	private FileInputStream fileInput;

	private Arquivo arquivo;

	private Socket socket;

	public byte[] transformarParaEnvio(File fileSelected, Socket socket) {
		this.socket = socket;
		byte[] bFile = new byte[(int) fileSelected.length()];
		try {
			fileInput = new FileInputStream(fileSelected);
			fileInput.read(bFile);
			fileInput.close();
		} catch (IOException ex) {
			Logger.getLogger(TransformarArquivo.class.getName()).log(Level.SEVERE, null, ex);
		}

		long tamanho = fileSelected.length() / 1024;

		arquivo = new Arquivo();
		arquivo.setConteudo(bFile);
		arquivo.setDataHoraUpload(new Date());
		arquivo.setNome(fileSelected.getName());
		arquivo.setTamanhoKB(tamanho);
		arquivo.setPortaDestino("5000");
		arquivo.setDiretorioDestino("Downloads");

		if (validaArquivo()) {
			return serializarArquivo();
		} else
			return null;
	}

	private byte[] serializarArquivo() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		Acoes.enviarMensagem(socket, bytes);
		return bytes.toByteArray();
	}

	private boolean validaArquivo() {
		if (arquivo.getTamanhoKB() > TAMANHO_PERMITIDO) {
			JOptionPane.showMessageDialog(null,
					"Tamanho máximo permitido atingido (" + (TAMANHO_PERMITIDO / 1024) + ")");
			return false;
		} else {
			return true;
		}
	}

	public void transformarParaReceber(Socket socket) {
		try {
			byte[] objectAsByte = new byte[socket.getReceiveBufferSize()];
			BufferedInputStream bf = new BufferedInputStream(socket.getInputStream());
			bf.read(objectAsByte);
			Arquivo arquivo = (Arquivo) getObjectFromByte(objectAsByte);
			String dir = arquivo.getDiretorioDestino().endsWith("/") ? arquivo.getDiretorioDestino() + arquivo.getNome()
					: arquivo.getDiretorioDestino() + "/" + arquivo.getNome();
			FileOutputStream fos = new FileOutputStream(dir);
			fos.write(arquivo.getConteudo());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object getObjectFromByte(byte[] objectAsByte) {
		Object obj = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(objectAsByte);
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();

			bis.close();
			ois.close();

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public FileInputStream getFis() {
		return fileInput;
	}

	public void setFis(FileInputStream fis) {
		this.fileInput = fis;
	}

}
