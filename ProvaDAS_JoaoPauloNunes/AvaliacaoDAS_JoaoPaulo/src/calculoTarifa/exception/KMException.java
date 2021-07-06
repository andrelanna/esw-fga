package calculoTarifa.exception;

public class KMException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String msg = "Excecao generica.";
	
	
	public KMException() {
		super(msg);
	}

	public KMException(String msg) {
		super(msg);
	}
}
