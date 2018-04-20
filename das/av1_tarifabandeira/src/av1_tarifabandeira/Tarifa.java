package av1_tarifabandeira;

public class Tarifa {
	
	private int descricao;
	private float kmRodados;
	private float numHorasParadas;
	
	public static final double VALORHORAPARADA = 31.72f;
	public static final double[] VALORKMRODADO = {2.85f, 3.66f};
	public static final double BANDEIRADA = 5.24f;
	
	public Tarifa(int descricao, float kmRodados, float numHorasParadas) {
		this.descricao = descricao; 
		this.kmRodados = kmRodados;
		this.numHorasParadas = numHorasParadas;
	}

	public int getDescricao() {
		return this.descricao;
	}
	
	public float getKmRodados() {
		return this.kmRodados;
	}
	
	public float getNumHorasParadas() {
		return this.numHorasParadas;
	}
	
	public static float calcularBaseDeCalculo(int descricao, float kmRodados, float numHorasParadas) {
		float valor = (float) (BANDEIRADA + 
				+ kmRodados * VALORKMRODADO[descricao - 1] + 
				+ numHorasParadas * VALORHORAPARADA);
				
	return valor;
	}

}
