public class TestExcecao {
    private CalculoService calculoService;

    @Before
    public void initializer() {
        this.calculoService = new CalculoService();
    }

    @Test(expected = BandeiraException.class)
    public void testBandeira() {
        Integer numBandeira = -1; // <= 1 and >= 2 == Não informado
        Integer numHorasParada = 1;
        Integer kmRodados = 100;
        Integer numHorasParada = 1;

        Bandeira bandeira = new Bandeira(numBandeira);
        TaxiTax tax = new TaxiTax(numHorasParada);

        Double valor = this.calculoService.getValor(bandeira, tax, kmRodados, numHorasParada);

        assertEquals(valor, 0, 0.001);
    }

    @Test(expected = KmException.class)
    public void testBandeira() {
        Integer numBandeira = 1;
        Integer numHorasParada = 1;
        Integer kmRodados = 0; // Kms <= 0
        Integer numHorasParada = 1;

        Bandeira bandeira = new Bandeira(numBandeira);
        TaxiTax tax = new TaxiTax(numHorasParada);

        Double valor = this.calculoService.getValor(bandeira, tax, kmRodados, numHorasParada);

        assertEquals(valor, 0, 0.001);
    }
}