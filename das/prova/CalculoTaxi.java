package prova;

public class CalculoTaxi {
	
	private float valor = 0.0f; 
	private float bandeirada = 5.24f;
	private float valorKmBandeira1 = 2.85f;
	private float valorKmBandeira2 = 3.66f;
	private float valorHoraParada = 31.72f;
	
	public float calculaValor(int bandeira, float kmRodados, float numHorasParadas){
		if(bandeira == 1)
			valor = bandeirada + kmRodados * valorKmBandeira1 + numHorasParadas * valorHoraParada;
		if(bandeira == 2)
			valor = bandeirada + kmRodados * valorKmBandeira2 + numHorasParadas * valorHoraParada;

		return valor;
	}
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
