public class TaxiTax {
    private static final Double valorHoraParada = 31.72;

    private Integer numHorasParadas;

    public TaxiTax(Integer numHorasParadas) {
        this.numHorasParadas = numHorasParadas;
    }

    public Double getValorHorasParadas() {
        return (Double) this.valorHoraParada * this.numHorasParadas;
    }
}
