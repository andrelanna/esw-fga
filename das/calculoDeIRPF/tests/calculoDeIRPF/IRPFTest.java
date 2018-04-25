package calculoDeIRPF;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import calculoDeIRPF.calculoDeIRPF.exceptions.RendimentosVaziosException;

public class IRPFTest {

    static IRPF irpf;
    
    @Mock
	private DependenteService dependenteService;

    @Before
    public void setup() {
        irpf = new IRPF();
    }
    
    @Test
    public void testeDeImpostoDeRenda() {
    	String descricao = "Salario";
		float valor = 5000f;
		Rendimento r = new Rendimento(descricao, valor); 
		
		Deducao d = new Deducao("Contribuicao previdenciaria",2000f);
		boolean deducaoPrevidencia = irpf.cadastrarDedudacao(d);
		
		List<Dependente> dependentes = new ArrayList<Dependente>();
		dependentes.add(new Dependente("João Lorival", "Não definido"));
		dependentes.add(new Dependente("Antonio Cavalo Ursão", "Arco iris"));
		dependentes.add(new Dependente("Flávio Gamer", "Metrosexual"));
		
		when(dependenteService.getDeducao(dependentes)).thenReturn((float) 568.77);
		
		float deducaoDependentes = dependenteService.getDeducao(dependentes);
    }
     
    
}
