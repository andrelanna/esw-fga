package Exemplo2;

public class MathApplication {
	private CalculatorService calcService;

	public void setCalcService(CalculatorService calcService) {
		this.calcService = calcService;
	}
	
	public double add (double v1, double v2) {
		return calcService.add(v1, v2);
	}
	
	public double sub (double v1, double v2) {
		return calcService.sub(v1, v2);
	}
	
}
