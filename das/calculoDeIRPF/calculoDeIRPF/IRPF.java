package calculoDeIRPF;


import java.text.DecimalFormat;
import java.util.ArrayList;

import calculoDeIRPF.exceptions.ImpostoNuloException;
import calculoDeIRPF.exceptions.RendimentosNulosException;
import calculoDeIRPF.exceptions.RendimentosVaziosException;

public class IRPF {

	ArrayList<Rendimento> rendimentos = new ArrayList<Rendimento>();
	ArrayList<Deducao> deducoes = new ArrayList<Deducao>();
	ArrayList<Dependente> dependentes = new ArrayList<Dependente>();
	
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
		return soma;
	}

	public int numTotalDeducoes() {
		int count = deducoes.size();
		return count;
	}
	
	public boolean cadastrarDependente(Dependente dp) {
		boolean resposta = dependentes.add(dp);
		return resposta;
	}
	
	public int numTotalDependentes() {
		int qtdDp = dependentes.size();
		return qtdDp;
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
	
	public double calculaBase() throws RendimentosNulosException {
		
		float calculoBase;
		float rendimentoTotal = totalRendimentos();
		float deducoesTotal = totalDeducoes();
	
		calculoBase = rendimentoTotal - deducoesTotal;
		
		return calculoBase;
	}
	
	public double calculaImposto() throws ImpostoNuloException, RendimentosNulosException {
		
		DecimalFormat df = new DecimalFormat("#.00");
		float calculoBase = (float) calculaBase();
		double valorImposto = 0;
		double valorParcial = 0;
		double parcialFinal = calculoBase;
		//System.out.println(calculoBase);
		
		if(calculoBase <= 1903.98 || calculoBase > (calculoBase-1903.98)){
			if(calculoBase<=1903.98)
				valorParcial = calculoBase;
			else
				valorParcial = 1903.98;
			parcialFinal = parcialFinal-valorParcial;
			valorImposto += parcialFinal;
			//System.out.println("Faixa 1\t "+valorParcial +"\t R$"+ df.format(valorImposto));
		}
		if(calculoBase>1903.98 && calculoBase <= 2826.66 || calculoBase > (calculoBase-2826.66)){
			if(calculoBase<=2826.66)
				valorParcial = calculoBase-1903.99;
			else
				valorParcial = 2826.66-1903.99;
			
			valorImposto = valorParcial*0.075;
			parcialFinal = parcialFinal- valorParcial;
			valorImposto += parcialFinal;
			//System.out.println("Faixa 2\t "+df.format(valorParcial) +"\t R$"+ df.format(valorImposto));
		}
		if(calculoBase <= 3751.06 && calculoBase > 2826.66 || calculoBase > (calculoBase-2826.66)){
			if(calculoBase<=3751.06)
				valorParcial = calculoBase-2826.67;
			else
				valorParcial = 3751.06-2826.67;
			
			valorImposto = valorParcial*0.15;
			parcialFinal = parcialFinal- valorParcial;
			valorImposto += parcialFinal;
			//System.out.println("Faixa 3\t "+df.format(valorParcial) +"\t R$"+ df.format(valorImposto));
		}
		if(calculoBase <= 4682.69 && calculoBase>3751.06 || calculoBase > (calculoBase-3751.06)){
			if(calculoBase<=4682.69)
				valorParcial= calculoBase-3751.07;
			else
				valorParcial = 4682.69 - 3751.07;
			
			valorImposto = valorParcial*0.225;
			parcialFinal = parcialFinal- valorParcial;
			valorImposto += parcialFinal;
			//System.out.println("Faixa 4\t "+df.format(valorParcial) +"\t R$"+ df.format(valorImposto));
		}
		if(calculoBase>4682.69){
			valorImposto += (parcialFinal*0.275);
			//valorImposto = valorParcial*0.275;
			//System.out.println("Faixa 5\t "+df.format(valorParcial) +"\t R$"+ df.format(valorImposto));
		}
		return valorImposto;
		
	
	}

	
}
