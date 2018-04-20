package suitCategoria;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import categoriasTeste.CategoriaTesteExcecao;
import categoriasTeste.CategoriaTesteFuncionalidade;
import testeExcecao.TesteExcecao;
import testeFuncionalidade.SuitFuncionalidades;
import testeFuncionalidade.TesteDeducao;
import testeFuncionalidade.TesteRendimento;

@RunWith(Categories.class)
@IncludeCategory({CategoriaTesteFuncionalidade.class, CategoriaTesteExcecao.class})
@SuiteClasses({SuitFuncionalidades.class, TesteExcecao.class})
public class TesteCategoria {
	public TesteCategoria() {
		// TODO Auto-generated constructor stub
	}
}
