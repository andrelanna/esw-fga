package calculoDeIRPF;

public class Dependente {
	String nome;
	String sexo;
	
	public Dependente(String nome, String sexo) {
		this.nome = nome; 
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
