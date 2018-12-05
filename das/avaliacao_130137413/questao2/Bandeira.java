public class Bandeira {
    private static final Double bandeira = 5.24;
    private static final Double kmBandeira1 = 2.85;
    private static final Double kmBandeira2 = 3.66;
    private Integer numBandeira;

    public Bandeira(Integer numBandeira) {
        this.numBandeira = numBandeira;
    }

    public Double getValorKm() throws BandeiraException {
        if (this.numBandeira != null && this.numBandeira <= 2 && this.numBandeira >= 1) {
            if (this.numBandeira == 1) {
                return kmBandeira1;
            } else if (this.numBandeira == 2) {
                return kmBandeira2;
            }
        }

        throw new BandeiraException();
    }

    public Double getValorBandeira() {
        return this.bandeira;
    }
}
