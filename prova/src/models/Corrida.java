package models;

import excecoes.BandeiraException;
import excecoes.KMException;

public class Corrida {
	private String bandeira;
	private final double bandeirada = 5.24;
	private double kmRodado;
	private double valorKM;
	private double numHorasParadas;
	private final double valorHoraParada = 31.72;
	
	public double calculaTarifa(String bandeira, double kmRodado, double numHorasParadas) 
			throws BandeiraException, KMException {
		double resultado;
		if(bandeira == null) {
			throw new BandeiraException();
		}
		if(kmRodado == 0) {
			throw new KMException();
		}
		if(bandeira.equals("Bandeira 1")) {
			this.valorKM = 2.85;
		}
		if(bandeira.equals("Bandeira 2")) {
			this.valorKM = 3.66;
		}
		resultado = (bandeirada + (kmRodado * valorKM) + (valorHoraParada * numHorasParadas));
		return resultado;
	}
}
