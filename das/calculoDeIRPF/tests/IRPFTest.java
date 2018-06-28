

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.Dependente;
import calculoDeIRPF.DependenteService;
import calculoDeIRPF.IRPF;
import calculoDeIRPF.Rendimento;
import calculoDeIRPF.calculoDeIRPF.AliquotaIRPF;
import calculoDeIRPF.calculoDeIRPF.exceptions.RendimentosVaziosException;

@RunWith(MockitoJUnitRunner.class)
public class IRPFTest {

    static IRPF irpf;
    
    @Mock
	private DependenteService dependenteService;

    @Before
    public void setup() {
        irpf = new IRPF();
    }
    
    @Test
    public void testeDeImpostoDeRenda() throws RendimentosVaziosException {
    	String descricao = "Salario";
		float valor = 5000f;
		Rendimento r = new Rendimento(descricao, valor);
		boolean rendimentoCadastrado = irpf.cadastrarRendimento(r);
		
		Deducao d = new Deducao("Contribuicao previdenciaria",2000f);
		boolean deducaoPrevidencia = irpf.cadastrarDedudacao(d);
		
		List<Dependente> dependentes = new ArrayList<Dependente>();
		dependentes.add(new Dependente("João Lorival", "Não definido"));
		dependentes.add(new Dependente("Antonio Cavalo Ursão", "Arco iris"));
		dependentes.add(new Dependente("Flávio Gamer", "Metrosexual"));
		
		when(dependenteService.getDeducao(dependentes)).thenReturn((float) 568.77);
		
		float deducaoDependentes = dependenteService.getDeducao(dependentes);
		Deducao d2 = new Deducao("Dependentes", deducaoDependentes);
		boolean deducao = irpf.cadastrarDedudacao(d2);
		
		AliquotaIRPF aliquota = new AliquotaIRPF();
		float base = irpf.calcularBaseDeCalculo();
		Double valorDoIRPF = aliquota.getImpostoDeRenda(Double.valueOf(base));
		
		assertEquals(valorDoIRPF, 504.87, 0.001);
    }     
    
}
