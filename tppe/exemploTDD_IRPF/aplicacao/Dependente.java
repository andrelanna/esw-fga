package aplicacao;

public class Dependente {
	String nome; 
	String cpf;
	
	private Dependente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public static Dependente obterDependente(String nome, String cpf) {
		Dependente d = new Dependente(nome, cpf);
		return d;
	}

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return cpf;
	}
}
