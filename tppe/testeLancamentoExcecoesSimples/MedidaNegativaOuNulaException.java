package testeLancamentoExcecoesSimples;

public class MedidaNegativaOuNulaException extends Exception{
	float medida; 
	
	public MedidaNegativaOuNulaException(float medida) {
		this.medida = medida;
	}
}
