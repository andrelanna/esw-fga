package calculoDeTarifa;

import calculoTarifa.exception.BandeiraException;
import calculoTarifa.exception.KMException;

public class CalculoTarifa {
	
	float valor = 0;
	public static float bandeirada = (float) 5.24;
	public static float custoHoraParada = (float) 31.72;
	
	public CalculoTarifa() {

	}
	
	public float calculaValorTarifa(String bandeira,int kmRodados,int numHorasParadas) throws BandeiraException, KMException {
		float valor = 0;
		float custoKMs = 0;
		float custoHoraParada = 0;
		
		if(kmRodados == 0) {
			throw new KMException();
		}
		
		custoKMs = calculaValorBandeira(bandeira,kmRodados);
		custoHoraParada = calculaValorHorasParadas(numHorasParadas);
		
		valor = bandeirada + custoKMs + custoHoraParada;
		System.out.println(valor);

		
		return valor;
	}
	
	private float calculaValorBandeira(String bandeira,int kmRodados) throws BandeiraException {
		if(bandeira == "Bandeira 1") {
			return (float) (2.85 * kmRodados);
		}else if(bandeira == "Bandeira 2") {
			return (float) (3.66 * kmRodados);
		}else {
			throw new BandeiraException();
		}
		
	}

	
	private float calculaValorHorasParadas(int numHorasParadas) {
		
		return (float) (custoHoraParada * numHorasParadas);
	}
	
	
}
// bandeirada 5,24
// valor km
	// 2,85 bandeira 1
	// 3,66 bandeira 2
// valor hora arada 31,72
//1 100 0
// valor = bandeirada + km rodados * valorKm + numero horas paradas * valor Hora parada