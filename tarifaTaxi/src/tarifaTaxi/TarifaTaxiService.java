package tarifaTaxi;

public class TarifaTaxiService {
	
	public double addBandeira(double bandeira) {
		return bandeira;
	}

	public int addKm(Integer km) {
		return km;
	}

	public int addHora(Integer hora) {
		return hora;
	}

	public Double calculoTarifa(double bandeira, Integer km, Integer hora) {
		double calculo;
		
		calculo = 5.24 + (bandeira * km) + (31.72 * hora);
		
		return calculo;
	}

}
