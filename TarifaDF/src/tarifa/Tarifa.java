package tarifa;

import Exceptions.BandeiraException;
import Exceptions.KmException;

public class Tarifa {
	
	public double calculoTarifa(String bandeira, int km, int hrsParadas) throws BandeiraException, KmException{
		double valorkm;
		double bandeirada = 5.24;
		double valorHoraParada = 31.72;
		
		if(bandeira == null){
			throw new BandeiraException();
		}
		else if(km == 0){
			throw new KmException();
		}
		
		if (bandeira == "Bandeira 1"){
			valorkm = 2.85;
		}
		else{
			valorkm = 3.66;
		}
			
		return (bandeirada + (km * valorkm) + (hrsParadas * valorHoraParada));
	}
}
