package calculoDeIRPF.exceptions;


public class ImpostoNuloException extends Exception{
	public static final String msg = "O imposto eh igual a zero.";
	
	public ImpostoNuloException() {
		super(msg);
	}
	
	public ImpostoNuloException(String msg) {
		super(msg);
	}
}
