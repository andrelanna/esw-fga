package prova1;

public class Taxi {
	
	public double getValorKm(int valor) {
		if(valor == 1) {
			return 2.85;
		}
		else {
			return 3.66;
		}
	}
	
	public double calcularCorrida(double kmRodados, int numHorasParadas, Integer valorKmCobrado) {
		
		if (valorKmCobrado < 0 || valorKmCobrado == null)
			throw new RuntimeException("Bandeira nao foi informada");
		
		if (kmRodados == 0)
			throw new RuntimeException("Numero de KMs nao pode ser zero");
		
		double valor=0;
		double valorKm = this.getValorKm(valorKmCobrado);
		valor = 5.24 + kmRodados * valorKm + numHorasParadas * 31.72;
		return valor;
	}
}
