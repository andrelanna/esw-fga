package calculoTarifa.exception;

public class BandeiraException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String msg = "Excecao generica.";
	
	
	public BandeiraException() {
		super(msg);
	}

	public BandeiraException(String msg) {
		super(msg);
	}
}
