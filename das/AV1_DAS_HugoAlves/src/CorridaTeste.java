import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CorridaTeste {
   private int bandeira;
   private int kmRodados;
   private int numHorasParadas;
   private double valorTotal;
   private Corrida corrida;

   @Before
   public void initialize() {
      corrida = new Corrida();
   }
	
   public CorridaTeste(int bandeira, int kmRodados, int numHorasParadas, double valorTotal) {
      this.bandeira = bandeira;
      this.kmRodados = kmRodados;
      this.numHorasParadas = numHorasParadas;
      this.valorTotal = valorTotal;
   }

   @Parameterized.Parameters
   public static Collection corrida() {
      return Arrays.asList(new Object[][] {
         { 1, 100, 0, 290.24 },
         { 2, 100, 0, 371.24 },
         { 1, 50, 1, 179.46 },
         { 2, 50, 1, 219.86 },
         { 1, 30, 2, 154.18 },
         { 2, 30, 2, 178.48 }
      });
   }

   @Test
   public void testCorrida() {
      assertEquals(valorTotal, 
      corrida.calculaTotalCorrida(bandeira, kmRodados, numHorasParadas));
   }
}