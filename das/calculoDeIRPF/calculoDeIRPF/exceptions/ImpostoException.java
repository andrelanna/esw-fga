package calculoDeIRPF.exceptions;

public class ImpostoException extends Exception{
	public static final String msg = "Generic Imposto exception";
	
	public ImpostoException() {
		super(msg);
	}
	
	public ImpostoException(String msg) {
		super(msg);
	}
}
