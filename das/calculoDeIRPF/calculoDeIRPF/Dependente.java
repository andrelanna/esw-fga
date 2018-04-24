package calculoDeIRPF;

public class Dependente {
	private Deducao deducao;
	private String nome;
	private String sexo;

	public Dependente(String nome, String sexo, Deducao deducao) {
		this.setNome(nome);
		this.setSexo(sexo);
		this.deducao = deducao;
	}

	public float getDeducao() {
		return this.deducao.getValor();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
