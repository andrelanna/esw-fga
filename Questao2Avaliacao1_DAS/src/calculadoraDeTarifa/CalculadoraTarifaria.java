package calculadoraDeTarifa;

public class CalculadoraTarifaria {
	
	public static float calculateTax( int bandeira, float kmRodados, float numHorasParado) {
		float bandeirada = (float) 5.24;
		float valorKm;
		float valorHoraParado = (float )31.72;
		if (bandeira == 1 ) {
			valorKm = (float) 2.85;
			
		}else {
			valorKm = (float) 3.66;
		}
			
		float valor = (bandeirada + kmRodados * valorKm + numHorasParado * valorHoraParado);
		return (valor);
	}

}
