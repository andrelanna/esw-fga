package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import avaliacao1.*;
import exeptions.*;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class BandeiraTests {
	
	@Mock
	Bandeira bandeira;
	
	@BeforeClass
	void setup() {
		doReturn(12.0).when(bandeira).bandeira(1,100,0); // 12 reais
		doReturn(22.0).when(bandeira).bandeira(2,100,0);// 22 reais 
		doReturn(32.0).when(bandeira).bandeira(1,50,1);// 32 reais 
		doReturn(42.0).when(bandeira).bandeira(2,50,1);// 42 reais
		doReturn(52.0).when(bandeira).bandeira(1,30,2);// 52 reais
		doReturn(62.0).when(bandeira).bandeira(2,30,3);// 62 reais
		//exeption
		doReturn(new BandeiraExeption()).when(bandeira).bandeira(3, 123,32);
		doReturn(new KMExeption()).when(bandeira).bandeira(2,0,2);
				
	}
	
	@Test
	public void testBandeira1(){
		Assert.assertEquals(bandeira.bandeira(1, 100, 0), 12.0, 0.0f);
		Assert.assertEquals(bandeira.bandeira(1, 50, 1), 32.0, 0.0f);
		Assert.assertEquals(bandeira.bandeira(1, 30, 2), 52.0, 0.0f);
	}
	
	@Test
	public void testBandeira2(){
		Assert.assertEquals(bandeira.bandeira(2, 100, 0), 22.0, 0.0f);
		Assert.assertEquals(bandeira.bandeira(2, 50, 1), 42.0, 0.0f);
		Assert.assertEquals(bandeira.bandeira(2, 30, 2), 62.0, 0.0f);
	}
	
	@Test
	public void testKMExeption() {
		try {
			bandeira.bandeira(3,123,32);
			assert(false);
		}	
		catch(KMExeption e) {
				assert(true);
		}
		
	}
	
	@Test
	public void testBandeiraExeption() {
		try {
			bandeira.bandeira(2,0,2);
			assert(true);
		}	
		catch(BandeiraExeption e) {
				assert(false);		
		}
	}

}