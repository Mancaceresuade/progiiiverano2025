package clase11;

public class FuerzaBrutaPermutaciones {

    // Método para intercambiar dos elementos en el array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Método recursivo para generar todas las permutaciones
    public static void generarPermutaciones(int[] array, int left, int right) {
        if (left == right) {
            if (!violarRestricciones(array)) {
                // Imprimir la permutación válida
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = left; i <= right; i++) {
                swap(array, left, i);
                generarPermutaciones(array, left + 1, right);
                swap(array, left, i);  // Deshacer el intercambio
            }
        }
    }

    // Método que verifica si la permutación viola las restricciones
    public static boolean violarRestricciones(int[] array) {
        return (array[1] == 2 || array[2] == 2) || (array[1] == 3 || array[2] == 3);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};  // Conjunto de números
        generarPermutaciones(array, 0, array.length - 1);  // Llamada inicial
    }
}
