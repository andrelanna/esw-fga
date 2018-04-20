package exceptions;

public class BandeiraException  extends Exception{
	public static final String msg = "Bandeira nula exception";
	public BandeiraException() {
		super(msg);
	}
}
