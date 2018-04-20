
public class Corrida {
	public static double bandeirada = 5.24;
	public static double valorHoraParada = 31.72;
	
	public double calculaTotalCorrida(int bandeira, int kmRodados, int numHorasParadas) {
		double totalCorrida = 0;
		double valorKm = calculaValorKm(bandeira);
		
		totalCorrida = bandeirada + (kmRodados * valorKm) + (numHorasParadas * valorHoraParada);
		
		return totalCorrida;
	}
	
	public double calculaValorKm(int bandeira) {
		double valorBandeira = 0.0;
		
		if(bandeira == 1) {
			valorBandeira = 2.85;
		}
		else {
			valorBandeira = 3.66;
		}
		
		return valorBandeira;
	}
}
