package tarifas;

public class TarifaTaxi {
	
	int bandeira;
	double bandeirada;
	double valorHoraParada;
	double kmRodados;
	double numHorasParadas;
	
	public TarifaTaxi(int bandeira, double kmRodados, double numHorasParadas) {
		this.setBandeira(bandeira);
		this.kmRodados = kmRodados;
		this.numHorasParadas = numHorasParadas;
		this.bandeirada = 5.24;
		this.valorHoraParada = 31.72;
	}
	
	public double getValorCorrida() {
		double valorKmTotal = this.kmRodados * this.getValorKm();
		double valorHoras = this.numHorasParadas * this.valorHoraParada;
		double valor = this.bandeirada + valorKmTotal + valorHoras;
		return valor;
	}

	public double getValorKm() {
		if (this.bandeira == 1) {
			return 2.85;
		} else {
			return 3.66;
		}
	}
	
	public int getBandeira() {
		return bandeira;
	}

	public void setBandeira(int bandeira) {
		if (bandeira < 2) {
			this.bandeira = 1;
		} else {
			this.bandeira = 2;
		}
	}

	public double getKmRodados() {
		return kmRodados;
	}

	public void setKmRodados(float kmRodados) {
		this.kmRodados = kmRodados;
	}

	public double getNumHorasParadas() {
		return numHorasParadas;
	}

	public void setNumHorasParadas(float numHorasParadas) {
		this.numHorasParadas = numHorasParadas;
	}

	public double getBandeirada() {
		return bandeirada;
	}

	public double getValorHoraParada() {
		return valorHoraParada;
	}
}
