public class App {
    public static void main(String[] args) throws Exception {
        int[][] mat = {{4,5,6},{7,8,9},{5,6,7}};
        System.out.println("El promedio es " + calcularPromedio(mat));
    }

    private static double calcularPromedio(int[][] mat) {
        int suma = 0;  // 1
        int n = 0;  // 1
        for (int i = 0; i < mat.length; i++) {  // 1 + n + 2n = 3n + 1
            for (int j = 0; j < mat[i].length; j++) { // 3n + 1
                suma = suma + mat[i][j]; // 3n
                n = n + 1; // 2n
            }
        }
        return suma/n; // 2
    }

    // f(n) = 1 + 1+ 3n + 1 + n (3n + 1 + 3n + 2n)
    // por consenso
    // f(n) = 8n^2 + 5n + 8

    // 8n^2 + 5n + 8  <= c n^2
    // 8n^2/n^2 + 5n/n^2 + 8/ n^2 <= c n^2/n^2
    // 8 + 5 / n + 8 / n^2  <= c
    // vemos para n = 1
    // 8 + 5 + 8  <= 21
    // f(n) = 8n^2 + 5n + 8  pertenece a O(n^2)  para c = 21 y n0 = 1

    
}
