package clase14;
import java.util.Arrays;

public class NReinasFuerzaBruta {
    
    public static boolean esValida(int[] tablero, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (tablero[i] == tablero[j]) return false; // Misma columna
                if (Math.abs(tablero[i] - tablero[j]) == j - i) return false; // Misma diagonal
            }
        }
        return true;
    }

    public static void resolverNReinas(int n) {
        int[] tablero = new int[n]; // tablero[i] almacena la columna de la reina en la fila i
        Arrays.fill(tablero, 0);

        int soluciones = 0;
        while (true) {
            if (esValida(tablero, n)) {
                soluciones++;
                // Imprimir la solución si es necesario
                // System.out.println(Arrays.toString(tablero));
            }

            // Generar la siguiente permutación en el tablero
            int fila = n - 1;
            while (fila >= 0 && tablero[fila] == n - 1) {
                tablero[fila] = 0;
                fila--;
            }

            if (fila < 0) break; // Si hemos recorrido todas las combinaciones, salimos

            tablero[fila]++;
        }

        System.out.println("Soluciones encontradas para " + n + " reinas: " + soluciones);
    }

    public static void main(String[] args) {
        int n = 10; // Puedes cambiar el valor de N
        long inicio = System.currentTimeMillis();
        resolverNReinas(n);
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo: " + (fin - inicio) + " ms");
    }
}
