package exemploTDD_IRPF.aplicacao;

public class Contribuinte {

	private String nome, 
	               cpf;
	
	//Lista de rendimentos
	Rendimento[] rends; 
	
	public Contribuinte(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public static Contribuinte obterContribuinte(String nome, String cpf) {
		return new Contribuinte(nome, cpf);
	}

	public boolean cadastrarRendimento(Rendimento r) {
		boolean resposta = false;
		//se nao ha vetor criado, crie um vetor de referencias para Rendimento
		if (rends == null) {
			rends = new Rendimento[0];
		}
		
		//Adicionar o objeto Rendimento no vetor de Rendimento rend
		int qtdeElementos = rends.length; 
		int novaQtdeElementos = qtdeElementos + 1; 
		Rendimento[] newRends = new Rendimento[novaQtdeElementos];
		//copiar cada elemento de rends em newRends
		for (int i=0; i<rends.length; i++) {
			newRends[i] = rends[i];
		}
		//adiciona o elemento
		if (newRends[qtdeElementos] == null) {
			newRends[qtdeElementos] = r;
			rends = newRends;
			//atualiza o vetor rends
			resposta = true;
		}
		
		return resposta;
	}

	public int getQtdeTotalRendimentos() {
		return 1;
	}

	public float getValorTotalRendimentos() {
		float resposta = 0f;
		for (Rendimento r : rends) { 
			if (!r.ehIsento()) {  //se nao for isento... 
				resposta += r.getValor(); //...considere na conta
			}
		}
		return resposta;
	}

}
