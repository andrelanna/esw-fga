package das.a1;

import exceptions.KMException;

public class Bandeira1 implements IBandeira {
	Double bandeirada = 5.24;
	Double kmRodados;
	Double valorKm = 2.85;
	Double numHorasParadas;
	Double valorHoraParada = 31.72;

	@Override
	public Double calculaValorTotal(Double kmRodados, Double numHorasParadas) {
		Double valorTotal = this.bandeirada + (kmRodados * this.valorKm) + (numHorasParadas * this.valorHoraParada);
		System.out.println(valorTotal);
		return valorTotal;
	}

}
