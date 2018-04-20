/* 
 * Aluno: Lucas Oliveira Silva
 * Matrícula: 15/0016018
 */

package calculaTarifaTaxi;

import excecoes.BandeiraException;
import excecoes.KMException;

public class CalculaTarifaTaxi {
	private final float bandeirada = 5.24f;
	private final float valorKmBandeira1 = 2.85f;
	private final float valorKmBandeira2 = 3.66f;
	private final float valorHoraParada = 31.72f;
	
	public float calculaTarifa (String bandeira, float kmRodados, float numHorasParadas) throws BandeiraException, KMException {
		float valor = 0;
		
			if (kmRodados == 0) {
				throw new KMException();	
			}
			
			if (bandeira.isEmpty()) {
				throw new BandeiraException();
			}
			
			else if (bandeira.equalsIgnoreCase("Bandeira 1")) {
				valor = bandeirada + kmRodados * valorKmBandeira1 + numHorasParadas * valorHoraParada;
			}
			
			else if (bandeira.equalsIgnoreCase("Bandeira 2")) {
				valor = bandeirada + kmRodados * valorKmBandeira2 + numHorasParadas * valorHoraParada;
			}
		
		return valor;
	}
}
