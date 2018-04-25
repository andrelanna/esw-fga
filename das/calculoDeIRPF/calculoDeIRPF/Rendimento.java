package calculoDeIRPF;

public class Rendimento {
	String descricao;
	float valor;
		
	public Rendimento(String descricao, float valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	public float getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
