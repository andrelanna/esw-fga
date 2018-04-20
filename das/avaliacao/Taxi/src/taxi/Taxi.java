package taxi;

import exceptions.BandeiraException;
import exceptions.KMException;

public class Taxi {
	final private double bandeirada = 5.24;
	final private double valorBandeira1 = 2.85;
	final private double valorBandeira2 = 3.66;
	final private double valorHoraParada = 31.72;
	
	public double calcularTarifaDeTaxi(double bandeira, int kmRodados, int numHorasParadas) throws BandeiraException, KMException {
		double valorKm;
		if (bandeira == 1) {
			valorKm = this.valorBandeira1;
		} else if (bandeira == 2) {
			valorKm = this.valorBandeira2;
		} else {
			throw new BandeiraException();
		}
		
		if (kmRodados == 0) {
			throw new KMException();
		}
		
		return this.bandeirada + kmRodados * valorKm + numHorasParadas *
					this.valorHoraParada;
	}
}
