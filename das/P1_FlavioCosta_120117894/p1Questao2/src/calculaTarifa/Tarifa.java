package calculaTarifa;

public class Tarifa {
	public double bandeirada = 5.24;
	public double valorKmB1 = 2.85;
	public double valorKmB2 = 3.66;
	public double valorHoraParada = 31.72;
	public double kmRodado = 0.0;
	public double horaParada = 0.0;
	
	public Tarifa(double kmRodado, double horaParada) {
		this.horaParada = horaParada;
		this.kmRodado = kmRodado;
	}
	
	public double getBandeirada() {
		return bandeirada;
	}
	public void setBandeirada(double bandeirada) {
		this.bandeirada = bandeirada;
	}
	public double getValorKmB1() {
		return valorKmB1;
	}
	public void setValorKmB1(double valorKmB1) {
		this.valorKmB1 = valorKmB1;
	}
	public double getValorKmB2() {
		return valorKmB2;
	}
	public void setValorKmB2(double valorKmB2) {
		this.valorKmB2 = valorKmB2;
	}
	public double getHoraParada() {
		return horaParada;
	}
	public void setHoraParada(double horaParada) {
		this.horaParada = horaParada;
	}
	public double getValorHoraParada() {
		return valorHoraParada;
	}
	public void setValorHoraParada(double valorHoraParada) {
		this.valorHoraParada = valorHoraParada;
	}
	public double getKmRodado() {
		return kmRodado;
	}
	public void setKmRodado(double kmRodado) {
		this.kmRodado = kmRodado;
	}
	
	public double valorCorridaB1(Tarifa tarifa){
		double valor = 0.0;
		
		valor = bandeirada + (kmRodado *valorKmB1) + (horaParada*valorHoraParada);
		
		return valor;
	}
	
	public double valorCorridaB2(Tarifa tarifa){
		double valor = 0.0;
		
		valor = bandeirada + (kmRodado *valorKmB2) + (horaParada*valorHoraParada);
		
		return valor;
	}
}
