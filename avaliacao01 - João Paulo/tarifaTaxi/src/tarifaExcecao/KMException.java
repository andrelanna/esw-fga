package tarifaExcecao;

@SuppressWarnings("serial")
public class KMException extends Exception{
	public KMException() {
		super("Kilometragem inv�lida");
	}
}
