package tarifas;

import tarifasException.BandeiraException;
import tarifasException.KMException;

public class Tarifa {
	private float bandeirada;
	private float[] valorKm = {2.85f, 3.66f};
	private float valorHoraParada;
	
	public Tarifa(float bandeirada, float valorHoraParada) {
		super();
		this.bandeirada = bandeirada;
		this.valorHoraParada = valorHoraParada;
	}
	
	public Tarifa() {
		super();
	}

	public float getBandeirada() {
		return bandeirada;
	}
	public void setBandeirada(float bandeirada) {
		this.bandeirada = bandeirada;
	}
	public float[] getValorKm() {
		return valorKm;
	}
	public void setValorKm(float[] valorKm) {
		this.valorKm = valorKm;
	}
	public float getValorHoraParada() {
		return valorHoraParada;
	}
	public void setValorHoraParada(float valorHoraParada) {
		this.valorHoraParada = valorHoraParada;
	}

	public float calculaTarifa (int bandeira, int kmRodados, int numHorasParadas) throws BandeiraException, KMException {
		if (bandeira < 1 || bandeira > 2) {
			throw new BandeiraException();
		} else if (kmRodados <= 0) {
			throw new KMException();
		} else {
			float valor = this.bandeirada +
					(kmRodados * this.valorKm[bandeira -  1]) +
					(numHorasParadas * this.valorHoraParada) ;
			return valor;
		}
	}
}
