package calculoDeIRPF.exceptions;

public class DeducaoException extends Exception{
	public static final String msg = "Excecao generica de Deducao";
	
	public DeducaoException() {
		super(msg);
	}
	
	public DeducaoException(String msg) {
		super(msg);
	}
}
