package calculoDeIRPF;

public class Imposto {
	private float aliquota;
	private float baseCalculo;
	private float valorImposto;

	public Imposto(float aliquota, float baseCalculo) {
		this.aliquota = aliquota;
		this.baseCalculo = baseCalculo;
		this.valorImposto = this.baseCalculo * this.aliquota;
	}

	public float getValorImposto() {
		return this.valorImposto;
	}
}
