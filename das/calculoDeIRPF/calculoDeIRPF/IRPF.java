package calculoDeIRPF;

import java.util.ArrayList;

import calculoDeIRPF.exceptions.DeducaoNulaException;
import calculoDeIRPF.exceptions.DeducaoVaziaException;
import calculoDeIRPF.exceptions.ImpostoSizeException;
import calculoDeIRPF.exceptions.RendimentosNulosException;
import calculoDeIRPF.exceptions.RendimentosVaziosException;

public class IRPF {

	ArrayList<Rendimento> rendimentos = new ArrayList<Rendimento>();
	ArrayList<Deducao> deducoes = new ArrayList<Deducao>();
	ArrayList<Imposto> impostos = new ArrayList<Imposto>();
	
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

	public int numRendimentos() throws RendimentosNulosException {
		if(rendimentos != null) {
			return rendimentos.size();
		} else {
			throw new RendimentosNulosException();
		}
	}

	public Object[] getRendimentos() {
		Object[] resposta = rendimentos.toArray();
		return resposta;
	}

	public boolean cadastrarDedudacao(Deducao d) throws DeducaoNulaException {
		if(d != null) {
			boolean resposta = deducoes.add(d);
			return resposta;
		} else {
			throw new DeducaoNulaException();
		}
	}

	public float totalDeducoes() throws DeducaoVaziaException {
		float soma = 0f;
		for (Deducao d : deducoes){
			soma += d.getValor();
		}
		if(soma != 0.0f) {
			return soma;
		} else {
			throw new DeducaoVaziaException();
		}
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
			
			for (Deducao d : deducoes) {
				baseDeCalculo -= d.getValor();
			}
			
			return baseDeCalculo;
		}
	}
	
	public int numImposto() throws ImpostoSizeException {
		int impostoSize = impostos.size();
		if(impostoSize <= 5) {
			return impostoSize;
		} else {
			throw new ImpostoSizeException();
		}
	}
	
	public boolean cadastrarImposto(Imposto imp) {
		return impostos.add(imp);
	}
	
}
