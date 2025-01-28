public class Actividad2 {

    public static void main(String[] args) {
        // Definir las matrices A y B
        int[][] A = {
            {1, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 8}
        };

        // Verificar si las matrices son multiplicables
        int filasA = A.length;
        int columnasA = A[0].length;
        int filasB = B.length;
        int columnasB = B[0].length;

        if (columnasA != filasB) {
            System.out.println("No se pueden multiplicar las matrices. El número de columnas de A no coincide con el número de filas de B.");
            return;
        }

        // Crear la matriz resultante C
        int[][] C = new int[filasA][columnasB];

        // Multiplicar las matrices
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Mostrar la matriz resultante C
        System.out.println("Matriz resultante C:");
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}