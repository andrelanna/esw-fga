package source;

import exception.BandeiraException;
import exception.KMException;

public class Corrida {
	public static final double BANDEIRADA = 5.24f;
	public static final double[] VALORKMRODADO = {2.85f, 3.66f};
	public static final double VALORHORAPARADA = 31.72f;
	
	private int bandeira;
	private double numKmRodados;
	private double numHorasParadas;
	
	
	public Corrida(int bandeira, double numKmRodados, double numHorasParadas) {
		super();
		this.bandeira = bandeira;
		this.numKmRodados = numKmRodados;
		this.numHorasParadas = numHorasParadas;
	}

	public double calculaValor() throws BandeiraException, KMException{
		if(this.bandeira != 1 &&  this.bandeira != 2) {
			throw new BandeiraException();
		}else if(this.numKmRodados <= 0.0000001 && this.numKmRodados>= -0.0000001) {
			// Este 0.0000001 e -0.0000001 representam a margem de erro, 
			// uma vez que números de ponto flutuante não são exatos
			throw new KMException();
		}
		
		double valor  =  BANDEIRADA + 
						this.numKmRodados * VALORKMRODADO[this.bandeira - 1] + 
						this.numHorasParadas * VALORHORAPARADA;
		
		return  valor;
	}

	public int getBandeira() {
		return bandeira;
	}


	public void setBandeira(int bandeira) {
		this.bandeira = bandeira;
	}


	public double getNumHorasParadas() {
		return numHorasParadas;
	}


	public void setNumHorasParadas(double numHorasParadas) {
		this.numHorasParadas = numHorasParadas;
	}


	public double getNumKmRodados() {
		return numKmRodados;
	}


	public void setNumKmRodados(double numKmRodados) {
		this.numKmRodados = numKmRodados;
	}
	
	
	

}
