package test;

public class KMException extends Exception{
	public static final String msg =  "Por favor uma kilometragem maior que 0.";
	
	public KMException(String msg) {
		super(msg);
	}
	
	public KMException() {
		super(msg);
	}
}
