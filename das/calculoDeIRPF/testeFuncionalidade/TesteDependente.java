package testeFuncionalidade;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.Dependente;

@RunWith(MockitoJUnitRunner.class)
public class TesteDependente {

	@Mock
	private Deducao mockedDeducao;

	@InjectMocks
	private Dependente dependente = new Dependente("Teste", "Indefinido", mockedDeducao);

	@Before
	public void setup() {
		when(mockedDeducao.getValor()).thenReturn(300f);
	}

	@Test
	public void testGetDeducao() {
		assertEquals(dependente.getDeducao(), 300f, 0f);
	}

}
