package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TarifaTests.class, TestBandeiraException.class, TestKMException.class})
public class AllTests {
	
}
