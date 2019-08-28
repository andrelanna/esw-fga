package exemploIgnore;

import java.util.HashSet;
import java.util.Iterator;

public class CadastroVeiculos {

	private HashSet<Veiculo> cadastro;
	
	public CadastroVeiculos() {
		cadastro = new HashSet<Veiculo>();
	}
	
	public static CadastroVeiculos obterCadastroVeiculos() {
		return new CadastroVeiculos();
	}

	/** Metodo para cadastrar um Veiculo caso ele ainda não tenha sido cadastrado.
	 * 
	 * @param v veiculo a ser cadastrado
	 * @return true, se cadastro foi realizado, false caso contrario
	 */
	public boolean cadastrarVeiculo(Veiculo v) {
		boolean resposta = false; 
		
		boolean encontrou = false; 
		Iterator<Veiculo> it = cadastro.iterator();
		while (it.hasNext()) { 
			Veiculo t = it.next();
			if (t.equals(v)) {
				encontrou = true; 
				break;
			}
		}
		
		if (!encontrou) 
			resposta = cadastro.add(v);
		
		return resposta;
	}

	/** Metodo para pesquisar se um veiculo está cadastrado, com base em sua marca e modelo
	 * 
	 * @param marca Marca do veiculo
	 * @param modelo Modelo do veiculo
	 * @return veiculo cadastrado ou null, caso nao esteja cadastrado
	 */
	public Veiculo pesquisarVeiculo(String marca, String modelo) {
		Veiculo resposta = null; 
		
		Iterator<Veiculo> it = cadastro.iterator(); 
		while (it.hasNext()) {
			Veiculo t = it.next();
			if (t.getMarca().equalsIgnoreCase(marca) && 
					t.getModelo().equalsIgnoreCase(modelo)) {
				resposta = t; 
				break;
			}
		}
		return resposta;
	}
}
