package calculoDeIRPF;

public class Imposto {
	private float aliquota;
	private float baseCalculo;
	private float valorImposto;
	
	public Imposto(float aliquota, float baseCalculo, float valorImposto) {
		this.aliquota = aliquota;
		this.baseCalculo = baseCalculo;
		this.valorImposto = valorImposto;
	}

	public float getAliquota() {
		return aliquota;
	}

	public void setAliquota(float aliquota) {
		this.aliquota = aliquota;
	}

	public float getBaseCalculo() {
		return baseCalculo;
	}

	public void setBaseCalculo(float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public float getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(float valorImposto) {
		this.valorImposto = valorImposto;
	}
	
}
