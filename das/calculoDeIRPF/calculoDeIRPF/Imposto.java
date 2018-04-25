package calculoDeIRPF;

public class Imposto {
	float aliquota;
	float baseCalculo;
	float valorImposto;
	
	public Imposto(float aliquota, float baseCalculo, float valorImposto) {
		super();
		this.aliquota = aliquota;
		this.baseCalculo = baseCalculo;
		this.valorImposto = valorImposto;
	}
	
	public float getAliquota() {
		return aliquota;
	}
	
	public float getBaseCalculo() {
		return baseCalculo;
	}
	
	public float getValorImposto() {
		return valorImposto;
	}

	public void setAliquota(float aliquota) {
		this.aliquota = aliquota;
	}

	public void setBaseCalculo(float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public void setValorImposto(float valorImposto) {
		this.valorImposto = valorImposto;
	}
	
}
