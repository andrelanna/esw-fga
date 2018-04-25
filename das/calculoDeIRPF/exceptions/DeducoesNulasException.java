package exceptions;

public class DeducoesNulasException extends RendimentoException{
	public static final String msg = "O total de deducoes eh igual a zero.";
	
	public DeducoesNulasException() {
		super(msg);
	}
	
	public DeducoesNulasException(String msg) {
		super(msg);
	}
}