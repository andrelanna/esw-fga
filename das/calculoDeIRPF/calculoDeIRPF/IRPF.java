package calculoDeIRPF;

import java.util.ArrayList; 

import calculoDeIRPF.exceptions.RendimentosVaziosException;


public class IRPF {

	
	public static ArrayList<IRPF> contribuintes = new ArrayList<IRPF>();
	
	private ArrayList<Rendimento> rendimentos = new ArrayList<Rendimento>();
	private ArrayList<Deducao> deducoes = new ArrayList<Deducao>();
	private float baseDeCalculo = 0f;
	
	
	public boolean cadastrarRendimento(Rendimento r) {
		
		Rendimento temp = consultarRendimento(r.descricao);
		
		if (temp != null) {
			rendimentos.remove(temp);
			r.valor += temp.valor;
		}
		
		boolean resposta = rendimentos.add(r);
		return resposta;
	}
	
	
	public boolean cadastratarContribuinte(IRPF c){
		return contribuintes.add(c);
	}
	

	private Rendimento consultarRendimento(String descricao) {
		Rendimento resposta = null;
		for (Rendimento r : rendimentos) {
			if (r.descricao.equalsIgnoreCase(descricao))
				resposta = r;
		}
		return resposta;
	}

	public float totalRendimentos() throws RendimentosVaziosException {
		float totalRendimentos = 0f;
		for (Rendimento r : rendimentos)
			totalRendimentos += r.getValor();
		if (totalRendimentos == 0) 
			throw new RendimentosVaziosException();
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
		return soma;
	}

	public int numTotalDeducoes() {
		int count = deducoes.size();
		return count;
	}

	public float calcularBaseDeCalculo() throws RendimentosVaziosException  {
		if (rendimentos.isEmpty())
			throw new RendimentosVaziosException();
		else {
			float baseDeCalculo = 0; 
			for (Rendimento r : rendimentos) {
				baseDeCalculo += r.getValor();
			}
			return baseDeCalculo;
		}
	}
	
	public Imposto calcularImposto() throws Exception {
		
		Imposto i = new Imposto();
		
		i.aliquota = 1;
		i.baseCalculo = this.baseDeCalculo;
		i.valorImposto = 1;
		
		return i;
	}
	
}
