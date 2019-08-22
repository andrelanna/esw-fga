package exemploTestesUnitariosComObjetos;

public class PA {

	private int a1;
	private int r;
	private int n;
	private int[] termos;
	private int soma;

	public PA(int a1, int r, int n) {
		this.a1 = a1;
		this.r = r;
		this.n = n;
	}

	public static PA getPA(int a1, int r, int n) {
		PA pa = new PA(a1, r, n);
		return pa;
	}

	public int[] getTermos() {
		termos = new int[n];
		for (int i=1; i<=n; i++) {
			termos[i-1] = a1 + (i-1) * r;
		}
		return termos;
	}

	public int getSoma() {
		soma = 0; 
		for (int i=0; i<termos.length; i++) {
			soma += termos[i];
		}
		return soma;
	}

}
