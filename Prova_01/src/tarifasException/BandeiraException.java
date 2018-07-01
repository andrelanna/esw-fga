package tarifasException;

public class BandeiraException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String msg = "Excecao generica de bandeiras.";

	public BandeiraException() {
		super(msg);
	}
	
	public BandeiraException(String msg) {
		super(msg);
	}
	
}
