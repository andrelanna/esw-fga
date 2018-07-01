package Exceptions;

public class BandeiraException extends Exception{
	private static final String msg = "BandeiraException";
	
	public BandeiraException(){
		super(msg);
	}
	
	public BandeiraException(String msg){
		super(msg);
	}
}
