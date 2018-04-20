package tarifaTaxi;

import tarifaExcecao.BandeiraException;
import tarifaExcecao.KMException;

public class tarifaTaxi {
	
	public double calculaTarifa( int bandeira, double kmRodados, double horasParadas) throws BandeiraException, KMException {
		double valorKM = 0;
		double bandeirada = 5.24;
		double valorHoraParada = 31.72;
		
		if(kmRodados > 0) {
			if(bandeira == 1) {
				valorKM = 2.85;
			} else if( bandeira == 2){
				valorKM = 3.66;
			} else {
				throw new BandeiraException();
			}
		} else {
			throw new KMException();
		}
			
		return bandeirada + kmRodados * valorKM + horasParadas * valorHoraParada; 
		
	}
}