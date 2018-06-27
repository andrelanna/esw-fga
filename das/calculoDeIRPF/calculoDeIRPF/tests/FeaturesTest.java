package calculoDeIRPF.tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import calculoDeIRPF.TesteFuncionalidades;

@RunWith(Categories.class)
@Category(TesteFuncionalidades.class)
@SuiteClasses({DeducaoTest.class, RendimentoTest.class, ImpostoTest.class, DependenteTeste.class})
public class FeaturesTest {

}
