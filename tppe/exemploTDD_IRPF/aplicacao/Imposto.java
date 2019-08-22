package aplicacao;

public class Imposto {
	float baseCalculo;
	
	float impostoFaixa1, 
		  impostoFaixa2, 
	      impostoFaixa3, 
	      impostoFaixa4, 
	      impostoFaixa5;
	
	float aliqFaixa1 = 0.0f,
		  aliqFaixa2 = 7.5f/100f,
		  aliqFaixa3 = 15.0f/100f,
		  aliqFaixa4 = 22.5f/100f,
		  aliqFaixa5 = 27.5f/100f;
	
	public Imposto(float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public void calcularImposto() {
		float valorFaixa5 = baseCalculo - 4664.68f;
		if (valorFaixa5 > 0) {
			impostoFaixa5 = valorFaixa5 * aliqFaixa5;
		}
		else { 
			impostoFaixa5 = 0;
			valorFaixa5 = 0;
		}
		
		float valorFaixa4 = baseCalculo - valorFaixa5 - 3751.06f;
		if (valorFaixa4 > 0) {
			impostoFaixa4 = valorFaixa4 * aliqFaixa4;
		}
		else { 
			impostoFaixa4 = 0;
			valorFaixa4 = 0;
		}
		
		float valorFaixa3 = baseCalculo - valorFaixa5 - valorFaixa4 - 2826.66f;
		if (valorFaixa3 > 0) {
			impostoFaixa3 = valorFaixa3 * aliqFaixa3;
		}
		else { 
			impostoFaixa3 = 0;
			valorFaixa3 = 0;
		}
		
		float valorFaixa2 = baseCalculo - valorFaixa5 - valorFaixa4 - valorFaixa3 - 1903.99f;
		if (valorFaixa2 > 0) {
			impostoFaixa2 = valorFaixa2 * aliqFaixa2;
		}
		else { 
			impostoFaixa2 = 0;
			valorFaixa2 = 0;
		}
		
		float valorFaixa1 = baseCalculo - valorFaixa5 - valorFaixa4 - valorFaixa3 - valorFaixa2;
		if (valorFaixa1 > 0) {
			impostoFaixa1 = valorFaixa1 * aliqFaixa1;
		}
		else { 
			impostoFaixa1 = 0;
			valorFaixa1 = 0;
		}
	}

	public float getFaixa1() {
		return impostoFaixa1;
	}

	public float getFaixa2() {
		return impostoFaixa2;
	}

	public float getFaixa3() {
		return impostoFaixa3;
	}

	public float getFaixa4() {
		return impostoFaixa4;
	}

	public float getFaixa5() {
		return impostoFaixa5;
	}
	
	

}
