
public class CorridaExcception extends Exception{
	public static final String msg = "Ocorreu uma excecao.";
	
	public CorridaExcception() {
		super(msg);
	}

	public CorridaExcception(String msg) {
		super(msg);
	}
}
