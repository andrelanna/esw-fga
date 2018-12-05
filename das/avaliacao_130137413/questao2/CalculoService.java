public class CalculoService {
    public Double getValor(Bandeira bandeira, TaxiTax tax, Integer kmRodados, 
                        Integer numHorasParadas) throws BandeiraException, KmException {
        if (kmRodados <= 0) {
            throw new KmException();
        }

        return bandeira.getValorBandeira()
                + kmRodados
                * bandeira.getValorKm()
                + numHorasParadas
                + tax.getValorHorasParadas();
    }
}
