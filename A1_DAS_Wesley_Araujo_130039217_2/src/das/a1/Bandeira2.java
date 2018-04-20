package das.a1;

public class Bandeira2 implements IBandeira {
	Double bandeirada = 5.24;
	Double kmRodados;
	Double valorKm = 3.66;
	Double numHorasParadas;
	Double valorHoraParada = 31.72;

	@Override
	public Double calculaValorTotal(Double kmRodados, Double numHorasParadas) {
		Double valorTotal = this.bandeirada + (kmRodados * this.valorKm) + (numHorasParadas * this.valorHoraParada);
		return valorTotal;
	}

}
