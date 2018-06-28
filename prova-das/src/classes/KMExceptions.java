package classes;

public class KMExceptions extends Exception {
	public static final String msg = "Excecao KM.";
	
	public KMExceptions() {
		super(msg);
	}

	public KMExceptions(String msg) {
		super(msg);
	}
}
