package aplicacao;

public class Deducao {

	private String descricao;
	private float valor;

	private Deducao(String descricao, float valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	public static Deducao obterDeducao(String descricao, float valor) {
		return new Deducao(descricao, valor);
	}

	public float getValor() {
		return valor;
	}

}
