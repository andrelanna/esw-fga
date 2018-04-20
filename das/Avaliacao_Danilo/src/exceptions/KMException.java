package exceptions;

public class KMException extends Exception {
	public static final String msg = "Kilometragem nula.";
	
	public KMException() {
		super(msg);
	}

	public KMException(String msg) {
		super(msg);
	}
}
