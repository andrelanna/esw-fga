package calculoDeIRPF;

public class Aliquota {

	static public float calcular(float rendimento){
		
		float v = 0f; 
		
		if(rendimento < 1903.98){
			v = 0;
		}else if(rendimento < 2826.65){
			v = 7.5f/100f; 
		}else if(rendimento < 3751.05){
			v = 15/100f;
		}else if(rendimento < 4664.68){
			v = 22.5f/100f;
		}else{
			v = 27.5f/100f;
		}
		
		return v;
	}
}
