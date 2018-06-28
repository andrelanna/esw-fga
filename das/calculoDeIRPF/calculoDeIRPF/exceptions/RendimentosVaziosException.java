package calculoDeIRPF.exceptions;

import exceptions.RendimentoException;

public class RendimentosVaziosException extends RendimentoException {
	private static final long serialVersionUID = 1L;
	public final static String msg = "Rendimentos vazios: o numero de rendimentos eh"
			+ " igual a zero (= nao ha rendimentos cadastrados)";

	public RendimentosVaziosException() {
		super(msg);
	}
}
