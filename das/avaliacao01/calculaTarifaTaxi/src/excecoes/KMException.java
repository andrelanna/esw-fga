package excecoes;

public class KMException extends Exception{
	final static String msg = "Km n�o pode ser igual a zero.";
	
	public KMException() {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
