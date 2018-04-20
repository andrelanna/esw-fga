package taxi;

import excecao.BandeiraException;
import excecao.KMException;

public class Taxi {
	public static final double BANDEIRA = 5.24;
	public static final double VALOR_HORA_PARADA = 31.72;
	public static final double BANDEIRA_1 = 2.85;
	public static final double BANDEIRA_2 = 3.66;

	private double valorTipoBandeira = 0;
	private double valorHoraParada;
	
	public double calculaTarifaTaxi(double kmRodados, double numHorasParadas) throws KMException, BandeiraException {
		if (kmRodados <= 0.000001 && kmRodados >= -0.000001) {
			throw new KMException();
		}else {
			if (this.valorTipoBandeira == 0) {
				throw new BandeiraException();
			}else {
				double valorRodado = kmRodados*this.valorTipoBandeira;
				
				double valorParado = numHorasParadas*this.valorHoraParada;

				return BANDEIRA + valorRodado + valorParado;
			}
		}
	}
	
	public void setValorTipoBandeira(double valorTipoBandeira) {
		this.valorTipoBandeira = valorTipoBandeira;
	}
	
	public void setValorHoraParada(double valorHoraParada) {
		this.valorHoraParada = valorHoraParada;
	}
}
