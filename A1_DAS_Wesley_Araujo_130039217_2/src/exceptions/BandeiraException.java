package exceptions;

public class BandeiraException extends Exception {
	public static final String message = "A bandeira não foi informada!";
			
	public BandeiraException() {
		super(message);
	}
	
	public BandeiraException(String message) {
		super(message);
	}
}
