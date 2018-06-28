package exceptions;

public class RendimentosNulosException extends RendimentoException{
	private static final long serialVersionUID = 1L;
	public static final String msg = "O total de rendimentos eh igual a zero.";

	public RendimentosNulosException() {
		super(msg);
	}

	public RendimentosNulosException(String msg) {
		super(msg);
	}
}
