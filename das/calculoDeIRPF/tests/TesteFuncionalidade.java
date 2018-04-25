package tests;

import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testCategories.TesteParametrizado;

@RunWith(Suite.class)
@SuiteClasses({ DeducaoTest.class, DependenteTests.class, ImpostoTests.class, RendimentoTest.class })
@Category(TesteParametrizado.class)
public class TesteFuncionalidade {

}
