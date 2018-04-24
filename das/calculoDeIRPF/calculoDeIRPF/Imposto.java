package calculoDeIRPF;

public class Imposto {
	public float aliquota = 0f;
	public float baseCalculo = 0f;
	public float deducoes = 0f;
	
	public float valorImposto(){
		return ( baseCalculo * (1 - aliquota) ) - deducoes;
	}
}
