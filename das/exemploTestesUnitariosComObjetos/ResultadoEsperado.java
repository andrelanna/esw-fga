package exemploTestesUnitariosComObjetos;

public class ResultadoEsperado {

	private int[] pa;
	private int soma;

	public ResultadoEsperado(int[] pa, int soma) {
		this.pa = pa;
		this.soma = soma;
	}

	public int getSoma() {
		return soma;
	}

	public int[] getPa() {
		return pa;
	}
	
}
