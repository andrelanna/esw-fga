package exemploIgnore;

public class Veiculo {

	private String marca;
	private String modelo;

	public Veiculo(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public static Veiculo obterVeiculo(String marca, String modelo) {
		return new Veiculo(marca, modelo);
	}
	
	public boolean equals(Object obj) {
		Veiculo v = (Veiculo) obj;
		boolean resposta = this.marca.equals(v.getMarca()) && 
						   this.modelo.equals(v.getModelo());
		return resposta;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

}
