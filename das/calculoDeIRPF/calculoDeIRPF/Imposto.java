package calculoDeIRPF;

public class Imposto {
	
	float aliquota = 0f;
	float baseCalculo = 0f;
	float deducoes = 0f;
	
	public Imposto(float valor_aliquota, float valor_baseCalculo, float valor_deducoes) throws Exception{
		aliquota 	= valor_aliquota;
		baseCalculo = valor_baseCalculo;
		deducoes 	= valor_deducoes;
		
		if( aliquota < 0 ){
			throw new Exception();
		}
		
		if(baseCalculo < 0){
			throw new Exception();
		}
		
		if(deducoes < 0){
			throw new Exception();
		}
	}
	
	public float valorImposto(){
		float result = ( baseCalculo * (1 - aliquota/100) ) - deducoes;
		return result > 0? result:0;
	}
}
