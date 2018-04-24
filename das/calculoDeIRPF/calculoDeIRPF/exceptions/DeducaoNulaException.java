package calculoDeIRPF.exceptions;

public class DeducaoNulaException extends DeducaoException {
	public static final String msg = "O total de deducoes he iqual a 0 (zero)";
	
	public DeducaoNulaException () {
		super(msg);
	}
	
	public DeducaoNulaException(String msg) {
		super(msg);
	}
}
