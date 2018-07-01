package exceptions;

public class BandeiraException extends Exception {
	public static final String msg = "Bandeira nao informada.";
	
	public BandeiraException() {
		super(msg);
	}

	public BandeiraException(String msg) {
		super(msg);
	}
}
