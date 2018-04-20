package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import av1_tarifabandeira.Tarifa;

@RunWith(Parameterized.class)
public class ParametrizacaoJUnit {

		private Tarifa tarifa;
		private int descricao;
		private float kmRodados;
		private float numHorasParadas;
		private float resultado;
		
		public ParametrizacaoJUnit(int descricao, float kmRodados, float numHorasParadas, float resultado) {
			super();
			this.descricao = descricao;
			this.kmRodados = kmRodados;
			this.numHorasParadas = numHorasParadas;
			this.resultado = resultado;
		}
		
		@Before
		public void setUp() {
		 this.tarifa = new Tarifa(this.descricao, this.kmRodados, this.numHorasParadas);
		}
		
		/*@Test
		public void testValorTarifa(){
			float valor = this.tarifa.calcularBaseDeCalculo(descricao, kmRodados, numHorasParadas);
			assertEquals(this.resultado, valor);
		}*/

		@Parameters
		public static Collection<Object[]> data() {
			return Arrays.asList(new Object[][] {
				{1, 100, 0, 290.24},
				{2, 100, 0, 371.24},
				{1, 50, 1, 179.46},
				{2, 50, 1, 219.96},
				{1, 30, 2, 154.18},
				{2, 30, 2, 178.40}
			});
		}
		

	}