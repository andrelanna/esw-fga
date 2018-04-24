package calculoDeIRPF;

public class Deducao {
	String descricao;
	float valor;
	
	public Deducao(String descricao, float valor) {
		this.descricao = descricao; 
		this.valor = valor;
	}

	public float getValor() {
		return this.valor;
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
