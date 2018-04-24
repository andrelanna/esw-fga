package calculoDeIRPF.tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import calculoDeIRPF.category.CategoriaDeducao;
import calculoDeIRPF.category.CategoriaDependente;
import calculoDeIRPF.category.CategoriaImposto;
import calculoDeIRPF.category.CategoriaRendimento;

@RunWith(Categories.class)
@IncludeCategory({CategoriaImposto.class, CategoriaRendimento.class, CategoriaDeducao.class, CategoriaDependente.class})
@SuiteClasses({ TesteDeducao.class, TesteDependente.class, TesteImposto.class, TesteRendimento.class })
public class TesteFuncionalidade {

}
