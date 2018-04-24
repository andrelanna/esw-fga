package calculoDeIRPF;

import java.util.ArrayList; 

import calculoDeIRPF.exceptions.RendimentosNulosException;
import calculoDeIRPF.exceptions.RendimentosVaziosException;

public class IRPF {
	
	public static final double[] ALIQUOTA = {0.0, 0.075, 0.15, 0.225, 0.275};
	public static final double[] FAIXA = {0.0, 1903.98, 2826.66, 3751.06, 4664.68};


	public static ArrayList<IRPF> contribuintes = new ArrayList<IRPF>();
	ArrayList<Rendimento> rendimentos = new ArrayList<Rendimento>();
	public ArrayList<Deducao> deducoes = new ArrayList<Deducao>();
	ArrayList<Dependente> dependentes = new ArrayList<Dependente>();
	ArrayList<Imposto> impostos = new ArrayList<Imposto>();

	public static void cadastrarContribuinte(IRPF irpf) {
		IRPF.contribuintes.add(irpf);
	}
	
	public void cadastrarDependente(Dependente dependente) {
		this.dependentes.add(dependente);
	}
	
	public boolean cadastrarRendimento(Rendimento r) {
		Rendimento temp = consultarRendimento(r.descricao);
		if (temp != null) {
			rendimentos.remove(temp);
			r.valor += temp.valor;
		}
		
		boolean resposta = rendimentos.add(r);
		return resposta;
	}

	private Rendimento consultarRendimento(String descricao) {
		Rendimento resposta = null;
		for (Rendimento r : rendimentos) {
			if (r.descricao.equalsIgnoreCase(descricao))
				resposta = r;
		}
		return resposta;
	}

	public float totalRendimentos() throws RendimentosNulosException {
		float totalRendimentos = 0f;
		for (Rendimento r : rendimentos)
			totalRendimentos += r.getValor();
		if (totalRendimentos == 0) 
			throw new RendimentosNulosException();
		else 
			return totalRendimentos;
	}

	public int numRendimentos() {
		return rendimentos.size();
	}

	public Object[] getRendimentos() {
		Object[] resposta = rendimentos.toArray();
		return resposta;
	}

	public boolean cadastrarDedudacao(Deducao d) {
		boolean resposta = deducoes.add(d);
		return resposta;
	}

	public float totalDeducoes() {
		float soma = 0f;
		for (Deducao d : deducoes){
			soma += d.getValor();
		}
		
		// soma += Dependente.DEDUCAO * this.dependentes.size();
		
		return soma;
	}

	public int numTotalDeducoes() {
		int count = deducoes.size();
		return count;
	}

	public float calcularBaseDeCalculo() throws RendimentosVaziosException, RendimentosNulosException {
		if (rendimentos.isEmpty()) {
			throw new RendimentosVaziosException();
		}else {
			float baseDeCalculo = this.totalRendimentos() - this.totalDeducoes(); 
			return baseDeCalculo;
		}
	}
	
	public double calcularImposto() throws RendimentosVaziosException, RendimentosNulosException {
		double baseCalculo = this.calcularBaseDeCalculo();
		
		double imposto = 0.0f;
		
		for(int i = 4; i >= 0; i--) {
			if (baseCalculo > FAIXA[i]) {
				imposto += (baseCalculo - FAIXA[i]) * ALIQUOTA[i];
				baseCalculo =  FAIXA[i];
			}
		}
		
		return imposto;
	}
	
	
}
