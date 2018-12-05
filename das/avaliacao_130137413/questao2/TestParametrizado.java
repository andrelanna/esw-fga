@RunWith(Parameterized.class)
public class TestParametrizado {

    private Integer numBandeira;
    private Integer kmRodados;
    private Integer numHorasParada;
    private Double resultado;
    private CalculoService calculoTaxiService;

    public TestParametrizado(Integer numBandeira, Integer kmRodados,
                               Integer numHorasParada, Double resultado) {
        this.numBandeira = numBandeira;
        this.kmRodados = kmRodados;
        this.numHorasParada = numHorasParada;
        this. resultado = resultado;
    }

    @Before
    public void initializer() {
        this.calculoService = new CalculoService();
    }

    @Test
    public void testeParametrizacaoJUnit() throws BandeiraException, KmException {
        Bandeira bandeira = new Bandeira(this.numBandeira);
        TaxiTax tax = new TaxiTax(this.numHorasParada);
        this.calculoTaxiService = new CalculoService();

        Double valor = calculoTaxiService.getValor(bandeira, tax, this.kmRodados, this.numHorasParada);

        assertEquals(valor, this.resultado, 0.001);
    }


    @Parameterized.Parameters(name = "{index}: {0}|{1}|{2}{3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            // { bandeira, kmRodados, numHorasParadas, resultado }
            {1, 100, 0, 290.24},
            {2, 100, 0, 371.24},
            {1, 50, 1, 179.46},
            {2, 50, 1, 219.96},
            {1, 30, 2, 154.18},
            {2, 30, 2, 178.48},
        });
    }
}
