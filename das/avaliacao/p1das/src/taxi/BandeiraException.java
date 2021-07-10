package taxi;

public class BandeiraException extends Exceptions{

	private static final long serialVersionUID = 1L;
	public final static String exc = "A bandeira não foi informada";
	
	public BandeiraException() {
		super(exc);
	}
}
