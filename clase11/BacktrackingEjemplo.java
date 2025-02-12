package clase11;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingEjemplo {

    public static void generarCombinaciones(int[] conjunto, List<Integer> combinacionActual, int posicion) {
        // Caso base: cuando se recorre todo el conjunto
        if (posicion == conjunto.length) {
            System.out.println(combinacionActual);
            return;
        }

        // Incluir el elemento actual
        combinacionActual.add(conjunto[posicion]);
        generarCombinaciones(conjunto, combinacionActual, posicion + 1);

        // Retroceder (backtrack): quitar el último elemento añadido
        combinacionActual.remove(combinacionActual.size() - 1);
        generarCombinaciones(conjunto, combinacionActual, posicion + 1);
    }

    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        List<Integer> combinacionActual = new ArrayList<>();
        generarCombinaciones(conjunto, combinacionActual, 0);
    }
}
