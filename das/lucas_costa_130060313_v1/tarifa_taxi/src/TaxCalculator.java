package src;


// Import Exceptions
import exceptions.*;

public class TaxCalculator {
	
	private double bandeirada = 5.24;
	private double standByValue = 31.72;
	
	public BandeiraTypes bandeiraType = BandeiraTypes.None;
	
	
	public double tax(double kmRun, double standByHours) throws Exception {
		
		if(kmRun <= 0){
			throw new KMException();
		}
		
		double kmValue = 0;
		
		switch(bandeiraType){
		case Bandeira1:
			kmValue = 2.85;
			break;
		case Bandeira2:
			kmValue = 3.66;
			break;
		case None:
			throw new BandeiraException();
		}
		
		double running = kmRun * kmValue;
		double standby = standByHours * standByValue;
		double result = bandeirada + running + standby;
		
		return result;
	}
	
}
