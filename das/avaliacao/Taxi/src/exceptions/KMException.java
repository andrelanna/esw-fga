package exceptions;

public class KMException extends Exception {
	public static final String msg = "KM Inválido";
	
	public KMException() {
		super(msg);
	}

	public KMException(String msg) {
		super(msg);
	}
}

