package tests;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DeducaoTest.class, RendimentoTest.class, RendimentosVaziosTest.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllTests {

}
