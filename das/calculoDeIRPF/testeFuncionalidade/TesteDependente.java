package testeFuncionalidade;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.Dependente;
import categoriasTeste.CategoriaTesteFuncionalidade;

@RunWith(MockitoJUnitRunner.class)
@Category(CategoriaTesteFuncionalidade.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
