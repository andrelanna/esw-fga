package exceptions;

public class BandeiraException extends Exception {
	public static final String msg = "Bandeira Inválida";
	
	public BandeiraException() {
		super(msg);
	}

	public BandeiraException(String msg) {
		super(msg);
	}
}
