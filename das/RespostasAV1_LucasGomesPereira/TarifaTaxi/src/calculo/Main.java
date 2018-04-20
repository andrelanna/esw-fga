package calculo;

import calculo.CalculoTarifa;

public class Main {

	public static void main(String[] args) throws BandeiraExeption, KMExeption {
		CalculoTarifa calculoTarifa = new CalculoTarifa();
		System.out.println(calculoTarifa.calcula(1, 100.0, 0.0));

	}

}
