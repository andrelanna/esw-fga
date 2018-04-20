package test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.BandeiraException;
import exceptions.KMException;
import tarifa.Tarifa;

@RunWith(Parameterized.class)
public class TarifaTestParametrizado {

	private double bandeirada;
	private double kmRodados;
	private double valorKm;
	private double numHorasParadas;
	private double valorHoraParada;
	private double valorViagem;

	 @Parameters
	 public static Collection<Object[]> data() {
		 return Arrays.asList(new Object[][] {     
			 {Tarifa.BANDEIRADA, 100.0, Tarifa.BANDEIRA_1, 0.0, Tarifa.VALOR_HORA_PARADA, 290.24},
			 {Tarifa.BANDEIRADA, 100.0, Tarifa.BANDEIRA_2, 0.0, Tarifa.VALOR_HORA_PARADA, 371.24},
			 {Tarifa.BANDEIRADA, 50.0, Tarifa.BANDEIRA_1, 1.0, Tarifa.VALOR_HORA_PARADA, 179.46},
			 {Tarifa.BANDEIRADA, 50.0, Tarifa.BANDEIRA_2, 1.0, Tarifa.VALOR_HORA_PARADA, 219.96},
			 {Tarifa.BANDEIRADA, 30.0, Tarifa.BANDEIRA_1, 2.0, Tarifa.VALOR_HORA_PARADA, 154.18},
			 {Tarifa.BANDEIRADA, 30.0, Tarifa.BANDEIRA_2, 2.0, Tarifa.VALOR_HORA_PARADA, 178.48}
         });
	 }

	
	public TarifaTestParametrizado(double bandeirada, double kmRodados, double valorKm, double numHorasParadas,
			double valorHoraParada, double valorViagem) {
		this.bandeirada = bandeirada;
		this.kmRodados = kmRodados;
		this.valorKm = valorKm;
		this.numHorasParadas = numHorasParadas;
		this.valorHoraParada = valorHoraParada;
		this.valorViagem = valorViagem;
	}
	
	
	@Test
	public void testCalculo() throws BandeiraException, KMException {
		Tarifa tarifa = new Tarifa(this.bandeirada, this.kmRodados, this.valorKm, this.numHorasParadas,
				this.valorHoraParada);
				
		Assert.assertEquals(tarifa.calculaValor(), this.valorViagem, 0.1);
	}
	
}
