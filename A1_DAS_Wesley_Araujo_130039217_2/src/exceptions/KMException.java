package exceptions;

public class KMException extends Exception {
	public static final String message = "Km igual a zero!";
	
	public KMException() {
		super(message);
	}
	
	public KMException(String message) {
		super(message);
	}
}
