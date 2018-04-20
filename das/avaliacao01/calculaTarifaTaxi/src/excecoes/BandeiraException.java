package excecoes;

public class BandeiraException extends Exception{
	final static String msg = "Bandeira não informada.";

	public BandeiraException() {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	
}
