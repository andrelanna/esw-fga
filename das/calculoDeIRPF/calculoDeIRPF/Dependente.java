package calculoDeIRPF;

public class Dependente {
	DependenteService dependenteService;
	private String name;
	private String sexo;
	
	public void setService(DependenteService ds) {
		dependenteService = ds; 
	}
	public float deducao() {
		return dependenteService.deducao();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
