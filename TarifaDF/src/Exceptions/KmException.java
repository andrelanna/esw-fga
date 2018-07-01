package Exceptions;

public class KmException extends Exception{

	private static final String msg = "KMException";
	
	public KmException(){
		super(msg);
	}
	
	public KmException(String msg){
		super(msg);
	}
}
