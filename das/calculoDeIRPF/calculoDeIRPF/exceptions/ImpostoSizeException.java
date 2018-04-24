package calculoDeIRPF.exceptions;

public class ImpostoSizeException extends ImpostoException {
	public static final String msg = "Numero de impostos maior que 5";
	
	public ImpostoSizeException() { 
		super(msg);
	}
	public ImpostoSizeException(String msg) {
		super(msg);
	}
}
