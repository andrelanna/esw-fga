package suiteCategoria;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import categoriasTeste.CategoriaTesteExcecao;
import categoriasTeste.CategoriaTesteFuncionalidade;
import testeExcecao.TesteExcecao;
import testeFuncionalidade.SuitFuncionalidades;

@RunWith(Categories.class)
@IncludeCategory({CategoriaTesteFuncionalidade.class, CategoriaTesteExcecao.class})
@SuiteClasses({ TesteExcecao.class, SuitFuncionalidades.class })
public class TesteCategoria {
	public TesteCategoria() {
	}
}
