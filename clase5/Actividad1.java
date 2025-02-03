package clase5;

import java.util.ArrayList;
import java.util.Arrays;

public class Actividad1 {

    
    static ArrayList<Integer> calcularCambio(int monto, int[] monedas) {
        ArrayList<Integer> cambio = new ArrayList<Integer>();
        int[] monedasOrdenadas = Arrays.copyOf(monedas, monedas.length);
        Arrays.sort(monedasOrdenadas);

        int i = monedasOrdenadas.length - 1;
        while (monto > 0 && i >= 0) {
            if (monto >= monedasOrdenadas[i]) {
                monto -= monedasOrdenadas[i];
                cambio.add(monedasOrdenadas[i]);
            }
            i--;
        }

        return monto == 0 ? cambio : null;
    }
 
}
