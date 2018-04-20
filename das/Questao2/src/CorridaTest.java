import org.junit.Test;

public class CorridaTest {

	@Test(expected = KMExceptions.class)
	public void KMExceptionTest() throws KMExceptions, BandeiraException {
		Corrida corrida = new Corrida(1, 0, 0);
	}
	
	@Test(expected = BandeiraException.class)
	public void BandeiraExceptionTest() throws KMExceptions, BandeiraException {
		Corrida corrida = new Corrida(0, 100, 0);
	}
}
