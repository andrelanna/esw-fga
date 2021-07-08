package taxi;

public class ValorCorridaTaxi implements CalcValorTaxi{

	@Override
	public double calcValorTaxi(double valores[]) {
		return valores[0] + (valores[1] * valores[2]) + (valores[3] * valores[4]);
	}
	

}
