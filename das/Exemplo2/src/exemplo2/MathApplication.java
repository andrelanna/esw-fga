package exemplo2;

public class MathApplication {
	private CalculatorService calcService;

	public void setCalcService(CalculatorService calcService) {
		this.calcService = calcService;
	}
	
	public double add (double v1, double v2) {
		return v1+v2;
	}
	
	public double sub (double v1, double v2) {
		return calcService.sub(v1, v2);
	}
	
	public double mult (double v1, double v2) {
		return calcService.mult(v1, v2);
	}
	
	public double div (double v1, double v2) {
		return calcService.div(v1, v2);
	}
	
}
