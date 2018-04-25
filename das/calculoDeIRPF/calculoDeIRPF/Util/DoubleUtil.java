package Util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleUtil {
    public static double round(Double valor, int casas) {
        if (casas < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(valor);
        bd = bd.setScale(casas, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
