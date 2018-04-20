package geral;

import exceptions.BandeiraException;
import exceptions.KMException;

public class BandeiraTaxi {
	public double bandeirada = 5.24;
	public double valorHoraParada = 31.72;
	public String bandeiraType;
	public double valorKm;
	
	public BandeiraTaxi(String bandeiraType) throws BandeiraException {
		this.bandeiraType= bandeiraType;
		switch(bandeiraType) {
		case ("Bandeira 1"):
				this.valorKm = 2.85;
				break;
		case ("Bandeira 2"):
				this.valorKm = 3.66;
				break;
		default:
			throw new BandeiraException();
		}
	}
	
	public double calculaValor(int kmRodados, int numHorasParadas) throws KMException {
		double valor = 0;
		if (kmRodados == 0) 
			throw new KMException();
		
		valor = bandeirada + (kmRodados * this.valorKm)
				+ numHorasParadas*valorHoraParada;
		return valor;
	}
}
