package testes;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import excecao.BandeiraException;
import excecao.KMException;
import taxi.Taxi;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TarifaTesteExcecao {
	
	private Taxi taxi;
	
	@Before
	public void setup() {
		taxi = new Taxi();
		taxi.setValorHoraParada(Taxi.VALOR_HORA_PARADA);
	}

	@Test(expected = BandeiraException.class)
	public void teste1BandeiraNaoInformada() throws BandeiraException, KMException {
		taxi.calculaTarifaTaxi(100.0, 0.0);
	}
	
	@Test(expected = KMException.class)
	public void teste2KmZerado() throws BandeiraException, KMException  {
		taxi.setValorTipoBandeira(2.85);
		taxi.calculaTarifaTaxi(0.0, 0.0);
	}
}
