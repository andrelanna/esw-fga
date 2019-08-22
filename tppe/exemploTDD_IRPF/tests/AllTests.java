package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CadastroDeducoesIntegraisTest.class, 
	CadastroRendimentosTeste.class, 
	CadastroDependentesTest.class, 
	BaseDeCalculoTest.class, 
	CalculoFaixasTest.class})
public class AllTests {

}
