package exceptions;

public class BandeiraException extends Exception{

	public static final String msg = "Excecao de bandeira";

	public BandeiraException() {
		super (msg);
	}
	
}