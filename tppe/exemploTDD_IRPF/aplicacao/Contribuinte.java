package aplicacao;

import java.util.LinkedList;
import java.util.List;

public class Contribuinte {

	private String nome, 
	               cpf;
	
	//Lista de rendimentos
	Rendimento[] rends;
	//Lista de Deducoes
	private List<Deducao> deducoes;
	//Lista de dependentes cadastrados
	Dependente[] dependentes;
	
	private Imposto imposto;
	
	public Contribuinte(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.dependentes = new Dependente[0];
		deducoes = new LinkedList<Deducao>();
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
		return rends.length;
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

	public boolean cadastrarDeducao(Deducao d) {
		boolean resposta = deducoes.add(d);
		return resposta;
	}

	public int getQtdeTotalDeducoes() {
		return deducoes.size() + (dependentes.length > 0? 1 : 0);
	}

	public float getValorTotalDeducoes() {
		float resposta = 0; 
		for (Deducao d : deducoes) 
			resposta += d.getValor();
		for (Dependente d : dependentes)
			resposta += 189.59f;
	 	return resposta;
	}

	public boolean cadastrarDependente(Dependente d) {
		return new CadastramentoDeDependentes(this, d).computar();
	}

	public int getNumTotalDependentes() {
		return dependentes.length;
	}

	public float getBaseCalculo() {
		return getValorTotalRendimentos() - getValorTotalDeducoes();
	}

	public Imposto calcularImposto() {
		imposto = new Imposto(getBaseCalculo());
		imposto.calcularImposto();
		return imposto;
	}

}
