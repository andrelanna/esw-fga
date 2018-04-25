package tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testCategories.TesteExecao;
import testCategories.TesteParametrizado;


@RunWith(Categories.class)
@IncludeCategory()
@SuiteClasses({ RendimentosVaziosTest.class, TesteFuncionalidade.class })
public class TesteCategorias {

}
