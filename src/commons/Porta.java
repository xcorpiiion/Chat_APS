package commons;

import java.util.Random;

public class Porta {

	public static int getPorta() {
		return new Random().nextInt((9999-1000)) + 1000;
	}
}
