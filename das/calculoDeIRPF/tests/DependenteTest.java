import calculoDeIRPF.Deducao;
import calculoDeIRPF.Dependente;
import calculoDeIRPF.DependenteService;
import calculoDeIRPF.IRPF;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DependenteTest {

	static IRPF irpf;

	@Mock
	private DependenteService dependenteService;
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testDeducaoPorDependentes() {
		List<Dependente> dependentes = new ArrayList<Dependente>();
		dependentes.add(new Dependente("João Lorival", "Não definido"));
		dependentes.add(new Dependente("Antonio Cavalo Ursão", "Arco iris"));
		dependentes.add(new Dependente("Flávio Gamer", "Metrosexual"));

		when(dependenteService.getDeducao(dependentes)).thenReturn((float) 568.77);

		assertEquals(dependenteService.getDeducao(dependentes), (float) 568.77, 0.001);
	}

}
