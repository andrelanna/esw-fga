package calculoDeTariaTaxi;

import test.BandeiraException;
import test.KMException;

public class Tarifa {
	String bandeira;
	float kmRodados;
	int horaParada;
	float valorKm;
	float bandeirada = 5.24f;
	float valorHoraParada = 31.72f;
	float valorTotal;
	
	public Tarifa(String bandeira, float kmRodados, int horaParada) throws BandeiraException{
		this.bandeira = bandeira;
		this.kmRodados = kmRodados;
		this.horaParada = horaParada;
		
		if(this.bandeira == "Bandeira 1")
			valorKm = 2.85f;
		else if(this.bandeira == "Bandeira 2")
			valorKm = 3.66f;
		else
			throw new BandeiraException();
	}
	
	
	public float calculaValorTarifa() throws KMException {
		if(this.kmRodados == 0)
			throw new KMException();
		
		this.valorTotal = this.bandeirada + (this.kmRodados * this.valorKm) + (this.horaParada + this.valorHoraParada);
		
		return this.valorTotal;
	}
}
