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
	private float baseDeCalculo;
	
	public float getBaseDeCalculo() {
		return baseDeCalculo;
	}

	public void setBaseDeCalculo(float baseDeCalculo) {
		this.baseDeCalculo = baseDeCalculo;
	}

	public void addImpostos() {
		for(int i = 0; i < 5; i++) {
			Imposto imposto = new  Imposto((float)ALIQUOTA[i], (float)FAIXA[i]);
			this.impostos.add(imposto);
		}
	}

	public IRPF() {
		this.addImpostos();
	}

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

	public void calcularBaseDeCalculo() throws RendimentosVaziosException, RendimentosNulosException {
		if (rendimentos.isEmpty()) {
			throw new RendimentosVaziosException();
		}else {
			float baseDeCalculo = this.totalRendimentos() - this.totalDeducoes(); 
			this.baseDeCalculo = baseDeCalculo;
		}
	}
	
	private void calcularImposto() throws RendimentosVaziosException, RendimentosNulosException {
		double baseCalculo = this.baseDeCalculo;
		
		double imposto = 0.0f;

		for(int i = 4; i >= 0; i--) {
			if (baseCalculo > this.impostos.get(i).getBaseCalculo()) {
				imposto = (baseCalculo - this.impostos.get(i).getBaseCalculo()) * this.impostos.get(i).getAliquota();
				this.impostos.get(i).setValorImposto((float)imposto);
				baseCalculo =  this.impostos.get(i).getBaseCalculo();
			}
		}
	}
	
	public double totalImposto() throws RendimentosVaziosException, RendimentosNulosException {
		this.calcularImposto();
		
		double impostoTotal = 0.0f;

		for(Imposto imposto: this.impostos) {
			impostoTotal += imposto.getValorImposto();
		}
		
		return impostoTotal;
	}

	public ArrayList<Imposto> getImpostos() {
		return impostos;
	}

	public void setImpostos(ArrayList<Imposto> impostos) {
		this.impostos = impostos;
	}
	
	
	
}
