package calculoDeIRPF.calculoDeIRPF;

import Util.DoubleUtil;

public class AliquotaIRPF {
    private static final Double ALIQUOTA_FAIXA_2 = 0.075;
    private static final Double ALIQUOTA_FAIXA_3 = 0.15;
    private static final Double ALIQUOTA_FAIXA_4 = 0.225;
    private static final Double ALIQUOTA_FAIXA_5 = 0.275;

    private static final Double LIMITE_SUPERIOR_FAIXA_1 = 1903.98;
    private static final Double LIMITE_SUPERIOR_FAIXA_2 = 2826.66;
    private static final Double LIMITE_SUPERIOR_FAIXA_3 = 3751.06;
    private static final Double LIMITE_SUPERIOR_FAIXA_4 = 4682.69;

    public static Double getImpostoDeRenda(Double base) {
        Double impostoTotal = 0.00;

        if (Double.compare(base, LIMITE_SUPERIOR_FAIXA_1) > 0) {
            if (Double.compare(base, LIMITE_SUPERIOR_FAIXA_2) > 0) {
                // Calcula valor dos limites AliquotaIRPF Faixa 2
                impostoTotal += (LIMITE_SUPERIOR_FAIXA_3 - LIMITE_SUPERIOR_FAIXA_2) * ALIQUOTA_FAIXA_2;

                if (Double.compare(base, LIMITE_SUPERIOR_FAIXA_3) > 0) {
                    // Calcula valor dos limites AliquotaIRPF Faixa 3
                    impostoTotal += (LIMITE_SUPERIOR_FAIXA_3 - LIMITE_SUPERIOR_FAIXA_2) * ALIQUOTA_FAIXA_3;

                    if (Double.compare(base, LIMITE_SUPERIOR_FAIXA_4) > 0) {
                        // Calcula valor dos limites AliquotaIRPF Faixa 3
                        impostoTotal += (LIMITE_SUPERIOR_FAIXA_4 - LIMITE_SUPERIOR_FAIXA_3) * ALIQUOTA_FAIXA_4;

                        // Calcula valor AliquotaIRPF Faixa 5 em relacao ao base
                        impostoTotal += (base - LIMITE_SUPERIOR_FAIXA_4) * ALIQUOTA_FAIXA_5;
                    } else {
                        // Calcula valor AliquotaIRPF Faixa 4 em relacao ao base
                        impostoTotal += (base - LIMITE_SUPERIOR_FAIXA_3) * ALIQUOTA_FAIXA_4;
                    }
                } else {
                    // Calcula valor AliquotaIRPF Faixa 3 em relacao ao base
                    impostoTotal += (base - LIMITE_SUPERIOR_FAIXA_2) * ALIQUOTA_FAIXA_3;
                }
            } else {
                // Calcula valor AliquotaIRPF Faixa 2 em relacao ao base
                impostoTotal += (base - LIMITE_SUPERIOR_FAIXA_1) * ALIQUOTA_FAIXA_2;
            }
        } else {
            // Isento
        }

        return DoubleUtil.round(impostoTotal, 2);
    }
}
