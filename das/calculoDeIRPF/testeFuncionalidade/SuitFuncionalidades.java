package testeFuncionalidade;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import categoriasTeste.CategoriaTesteFuncionalidade;

@RunWith(Categories.class)
@IncludeCategory(CategoriaTesteFuncionalidade.class)
@SuiteClasses({
	TesteDeducao.class,
	TesteDependente.class,
	TesteRendimento.class,
	TesteImposto.class,
	TesteIRPF.class,
})
public class SuitFuncionalidades {

}
