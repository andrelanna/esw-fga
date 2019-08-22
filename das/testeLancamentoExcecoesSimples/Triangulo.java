package testeLancamentoExcecoesSimples;

public class Triangulo {

	private float l1;
	private float l2;
	private float l3;

	public Triangulo(float i, float j, float k) {
		this.l1 = i; 
		this.l2 = j; 
		this.l3 = k;
	}

	public static Triangulo obterTriangulo(float i, float j, float k) throws MedidaNegativaOuNulaException {
		if ( i <= 0) 
			throw new MedidaNegativaOuNulaException(i);
		if ( j <= 0) 
			throw new MedidaNegativaOuNulaException(j);
		if ( k <= 0) 
			throw new MedidaNegativaOuNulaException(k);
		
		Triangulo t = new Triangulo(i, j, k);
		return t;
	}

}
