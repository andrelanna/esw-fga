package calculoDeIRPF;

public class Dependente {
	private Deducao deducao;
	private String nome;
	private String sexo;

	public Dependente(String nome, String sexo, Deducao deducao) {
		this.nome = nome;
		this.sexo = sexo;
		this.deducao = deducao;
	}

	public float getDeducao() {
		return this.deducao.getValor();
	}
}
