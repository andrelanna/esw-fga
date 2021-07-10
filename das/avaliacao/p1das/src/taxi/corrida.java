package taxi;

public class corrida {
	
	static double valor;
	static double bandeirada = 5.24;
	static double km = 0;	
	static double valorKm = 0;
	static double numHorasParadas = 0;
	static double valorHorasParadas = 31.72;
	
	public static double calculaCorrida(int bandeira, double km, double numHorasParadas){ 
		
		if(bandeira==1){
			valorKm=2.85;
		} else if(bandeira==2){
			valorKm=3.66;
		}
		
		valor = bandeirada + (km * valorKm) + 
				(numHorasParadas * valorHorasParadas);
		
		return valor;
		}
	
	public static double bandeira1calculaKm(double km){ 
			
			valorKm=2.85;
			valor = 5.24 + (km * 2.85);
			
			return valor;
		}
}
