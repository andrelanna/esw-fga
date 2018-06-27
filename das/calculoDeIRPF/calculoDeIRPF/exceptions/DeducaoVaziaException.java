package calculoDeIRPF.exceptions;

public class DeducaoVaziaException  extends DeducaoException{
	public static final String msg = "Nao a deducoes cadastradas";
	
	public DeducaoVaziaException () {
		super(msg);
	}
	
	public DeducaoVaziaException(String msg) {
		super(msg);
	}
}
