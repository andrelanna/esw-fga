/*
 * Lucas Gomes Pereira
 * 13/0013242
 * 
 * */

package calculo;

public class CalculoTarifa {
	private double bandeirada;
	private double valorHoraParada;
	private double valorKm;
	
//	//Construtor
//	public CalculoTarifa() {
//		CalculoTarifa.bandeirada = 5.24;
//		CalculoTarifa.valorHoraParada = 31.72;
//		this.valorKm = 0;
//	}
	
	//Calculo da tarifa
	public double calcula(int bandeira, double kmRodados, double numHorasParadas) throws BandeiraExeption, KMExeption {
		bandeirada = 5.24;
		valorHoraParada = 31.72;
		valorKm = 0;
		
		//Define a bandeira
		if (bandeira == 1) {
			valorKm = 2.85;
		} else if (bandeira == 2) {
			valorKm = 3.66;
		} else {
			//Exeption
			throw new BandeiraExeption();
		}
		
		//Verifica a kilometragem
		if(kmRodados <= 0) {
			throw new KMExeption();
		}
		
		double valorFinal;
		valorFinal = bandeirada + kmRodados*valorKm + numHorasParadas*valorHoraParada;
		
		return valorFinal;
	}
}
