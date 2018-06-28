package classes;

public class BandeirasException extends Exception {
	public static final String msg = "Excecao Bandeira.";
	
	public BandeirasException() {
		super(msg);
	}

	public BandeirasException(String msg) {
		super(msg);
	}
}