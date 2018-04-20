package prova;

import exceptions.BandeiraException;
import exceptions.KMException;

public class TarifaTaxi {
	final float bandeirada = 5.25f;
	final float valorHoraParada = 31.72f;
	public float calculaTarifa(String tipoBandeira, int km, int horaParada) throws BandeiraException, KMException {
		float total = 0f;
		
		if(km == 0) {
			throw new KMException();
		}
		if(tipoBandeira.isEmpty()) {
			throw new BandeiraException();
		}
		if(tipoBandeira == "Bandeira 1") {
			total = bandeirada + (km * 2.85f) + (horaParada * valorHoraParada);
		} else if(tipoBandeira == "Bandeira 2") {
			total = bandeirada + (km * 3.66f) + (horaParada * valorHoraParada);
		}
		return total;
	}
	
}
