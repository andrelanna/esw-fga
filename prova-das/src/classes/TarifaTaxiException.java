package classes;

public class TarifaTaxiException extends Exception {
	public static final String msg = "Exceção nas tarifas do taxi";
	
	public TarifaTaxiException() {
		super(msg);
	}
 
	public TarifaTaxiException(String msg) {
		super(msg);
	} 
}
