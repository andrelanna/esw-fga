package tarifaExcecao;

@SuppressWarnings("serial")
public class BandeiraException extends Exception{
	public BandeiraException() {
		super("Bandeira nao permitida");
	}
}
