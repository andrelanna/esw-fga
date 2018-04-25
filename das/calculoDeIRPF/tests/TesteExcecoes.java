import calculoDeIRPF.IRPF;
import calculoDeIRPF.calculoDeIRPF.exceptions.RendimentosVaziosException;
import calculoDeIRPF.exceptions.RendimentosNulosException;
import org.junit.Before;
import org.junit.Test;

public class TesteExcecoes {

    IRPF irpf;

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Test(expected = RendimentosVaziosException.class)
    public void testBaseDeCalculoSemRendimentos() throws RendimentosVaziosException {
        irpf.calcularBaseDeCalculo();
    }

    @Test(expected = RendimentosNulosException.class)
    public void testCalculoImpostoSemRendimentos() throws RendimentosNulosException {
        irpf.totalRendimentos();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test0opasso_AcessarRendimentoNaoCadastrado() {
        Object[] rends = irpf.getRendimentos();
        Object r = rends[0];
    }

}
