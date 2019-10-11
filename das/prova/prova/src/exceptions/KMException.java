package exceptions;

public class KMException extends Exception{
	public static final String msg = "KM zero exception";
	public KMException() {
		super(msg);
	}
}
