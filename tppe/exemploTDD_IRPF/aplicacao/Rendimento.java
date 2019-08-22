package aplicacao;

public class Rendimento {

	private String descricao;  //nome do rendimento, ex.: salario, aluguel, bolsa de estudo, etc...
	private float valor;   //valor total do rendimento
	private boolean isentoIR;  //true = isento de imposto, false = deve ser considerado no calculo do IRPF
	
	public Rendimento(String descricao, float valor, boolean isentoIR) {
		this.descricao = descricao;
		this.valor = valor;
		this.isentoIR = isentoIR;
	}

	public static Rendimento obterRendimento(String descricao, float valor, boolean isentoIR) {
		return new Rendimento(descricao, valor, isentoIR);
	}

	public boolean ehIsento() {
		return isentoIR;
	}

	public float getValor() {
		return valor;
	}

}
