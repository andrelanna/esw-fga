package aplicacao;

public class CadastramentoDeDependentes {

	Contribuinte contribuinte; //referencia ao objeto original
	//um campo para cada variavel temporaria e parametro do metodo 
	//de origem
	Dependente d;
	boolean resposta;
	int qtdeNovaDependentes;
	Dependente[] temp;
	int posicaoInsercao;
	
	
	//Construtor que recebe objeto de origem e parametros
	public CadastramentoDeDependentes(Contribuinte contribuinte, 
			                          Dependente d) {
		this.contribuinte = contribuinte;
		this.d = d;
	}
	
	
	boolean computar() {
		resposta = false;
		//criar vetor de dependentes, se necessario
		if (contribuinte.dependentes == null) {
			contribuinte.dependentes = new Dependente[0];
		}
		
		//criar vetor temporario com uma posicao a mais do que o vetor de dependentes atual
		qtdeNovaDependentes = contribuinte.dependentes.length + 1;
		temp = new Dependente[qtdeNovaDependentes];
		
		//copiar elementos do vetor dependentes para o vetor temporario
		for (int i = 0; i<contribuinte.dependentes.length; i++) {
			temp[i] = contribuinte.dependentes[i];
		}
		
		//adicionar o novo dependente ao vetor temp
		posicaoInsercao = contribuinte.dependentes.length;
		if (temp[posicaoInsercao] == null) {
			temp[posicaoInsercao] = d;
			resposta = true;
		}
		
		//atualizar a referencia do vetor dependentes
		contribuinte.dependentes = temp;
		
		return resposta;
	}
	
}
