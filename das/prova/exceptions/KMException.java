package prova.exceptions;

public class KMException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final static String msg = "Numero de km nao pode ser zero";
	
	public KMException() {
		super(msg);
	}

	public KMException(String msg) {
		super(msg);
	}

}