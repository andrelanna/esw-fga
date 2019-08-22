package testeLancamentoExcecoesProfundas;

public class MedidaNegativaOuNulaException extends Exception{
	private float medida;
	private String lado; 
	
	public MedidaNegativaOuNulaException(String lado, float medida) {
		super("A medida informada para o lado " + lado + " é inválida: " + medida);
		this.lado = lado;
		this.medida = medida;
	}
}
