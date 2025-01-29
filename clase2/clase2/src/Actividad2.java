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

        // hasta aca, aprox,  11

        // Multiplicar las matrices
        for (int i = 0; i < filasA; i=i+1) {  // 1 + n + 1 + 2*n = 2 + 3n
            for (int j = 0; j < columnasB; j++) {  // 2 + 3n
                /*
                for (int k = 0; k < columnasA; k++) { // 2 + 3n
                    C[i][j] += A[i][k] * B[k][j]; // 3n
                }
                 */
                int k = 0; // 1
                while( k < columnasA ) { // n
                    C[i][j] += A[i][k] * B[k][j]; // 3n    
                    k++;  // n
                }    
            }
        }
        // 2 + 3n + n * ( 2 + 3n + n * ( 2 + 3n + 3n)  )
        // 2 + 3n + n * ( 2 + 3n + 2n + 3n^2 + 3n^2) 
        // 2 + 3n + 2n + 3n^2 + 2n^2 + 3n^3 + 3n^3
        // 2 + 5n + 5n^2 + 6n^3
        // f(n) = 2 + 5n + 5n^2 + 6n^3
        // demostracion
        // 2 + 5n + 5n^2 + 6n^3 <= c * n^3
        // 2/n^3 + 5n / n^3 + 5 n^2 / n^3 + 6 n^3 / n^3 <= c * n^3 / n^3
        // 2/n^3 + 5n / n^3 + 5 n^2 / n^3 + 6 <= c
        // n0 = 1
        // 2 + 5 + 5 + 6 <= c
        // 2 + 5 + 5 + 6 <= 18
        // f(n) = 2 + 5n + 5n^2 + 6n^3 pertenece a O(n^3) para c = 18 y n0= 1 

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