package tarifa;

import exceptions.BandeiraException;
import exceptions.KMException;

public class Tarifa {

	private double bandeirada;
	private double kmRodados;
	private double valorKm;
	private double numHorasParadas;
	private double valorHoraParada;
	
	public final static double VALOR_HORA_PARADA = 31.72;
	public final static double BANDEIRA_1 = 2.85;
	public final static double BANDEIRA_2 = 3.66;
	public final static double BANDEIRADA = 5.24;
	
	public Tarifa(double bandeirada, double kmRodados, double valorKm, double numHorasParadas, double valorHoraParada) {
		this.bandeirada = bandeirada;
		this.kmRodados = kmRodados;
		this.valorKm = valorKm;
		this.numHorasParadas = numHorasParadas;
		this.valorHoraParada = valorHoraParada;
	}
	
	public double calculaValor() throws BandeiraException, KMException{
		if(this.valorKm == 0f) {
			throw new BandeiraException("Não é possível calcular uma viagem sem bandeira");
		}
		
		if(this.kmRodados == 0f) {
			throw new KMException("Não é possível calcular um valor para uma viagem sem km");
		}
		
		double valor = bandeirada + kmRodados * valorKm + numHorasParadas *
				valorHoraParada;
		return valor;
	}
}
