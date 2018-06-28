package exceptions;

public class RendimentoException extends Exception{
	private static final long serialVersionUID = 1L;
	public static final String msg = "Excecao generica de Rendimentos.";

	public RendimentoException() {
		super(msg);
	}

	public RendimentoException(String msg) {
		super(msg);
	}
}
