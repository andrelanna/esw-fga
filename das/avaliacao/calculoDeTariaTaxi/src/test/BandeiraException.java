package test;

public class BandeiraException extends Exception{
	public static final String msg =  "Por favor informe a bandeira.";
	
	public BandeiraException(String msg) {
		super(msg);
	}
	
	public BandeiraException() {
		super(msg);
	}

}
