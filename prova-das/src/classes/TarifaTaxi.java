package classes;

public class TarifaTaxi {
	public static float calculaTarifa(int bandeira, float kmRodados, int horasParadas) throws BandeirasException, KMExceptions {
		if(bandeira == 1) {
			return (5.24f + (2.85f * kmRodados) + (31.72f * horasParadas));
		}
		if(bandeira == 2) {
			return (5.24f + (3.66f * kmRodados) + (31.72f * horasParadas));
		} if (bandeira  == 0) {
			throw new BandeirasException();
		} else if (kmRodados == 0) {
			throw new KMExceptions();
		} else {
			return 0;
		}
	}
}