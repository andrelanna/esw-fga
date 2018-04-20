import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class Corrida {
	
	private final double bandeirada = 5.24;
	private final double valorKM1 = 2.85;
	private final double valorKM2 = 3.66;
	private final double horaParada = 31.72;
	
	private double kmRodados;
	private double numHorasParado;
	private int numBandeira;
	
	public Corrida(int numBandeira, double kmRodados, double numHorasParado) throws KMExceptions, BandeiraException {
		this.numBandeira = numBandeira;
		this.kmRodados = kmRodados;
		this.numHorasParado = numHorasParado;
		
		if(kmRodados == 0) {
			throw new KMExceptions();
		}
		
		if(numBandeira != 1 && numBandeira != 2) {
			System.out.print("Oi");
			throw new BandeiraException();
		}
	}
	
	public double GetValue() {
		double value = 0;
		if(numBandeira == 1) {
			value =  bandeirada + valorKM1 * kmRodados + numHorasParado * horaParada; 
		} else {
			value =  bandeirada + valorKM2 * kmRodados + numHorasParado * horaParada;
		}
		
		return value;
	}
	
}
