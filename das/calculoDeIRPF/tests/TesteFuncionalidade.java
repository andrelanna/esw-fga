package tests;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.Categories.DeducaoCategory;
import tests.Categories.ExceptionsCategory;
import tests.Categories.RendimentoCategory;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;

@RunWith(Categories.class)
@IncludeCategory({ DeducaoCategory.class, RendimentoCategory.class, ExceptionsCategory.class  })
@SuiteClasses({ RendimentoTest.class, DeducaoTest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteFuncionalidade {

}
