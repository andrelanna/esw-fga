package prova.exceptions;

public class BandeiradaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final static String msg = "Bandeirada nao informada";
	
	public BandeiradaException() {
		super(msg);
	}

	public BandeiradaException(String msg) {
		super(msg);
	}

}
