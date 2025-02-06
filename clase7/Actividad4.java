public class actividad4 {
    public static void main(String[] args) {
        int presupuesto = 35;
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int n = costos.length;
 
        // Solución por programación dinámica
        System.out.println("Solución por Programación Dinámica:");
        int[][] dp = new int[n + 1][presupuesto + 1];
       
        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j],
                                      ganancias[i-1] + dp[i-1][j-costos[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
 
        // Imprimir la tabla
        System.out.println("Tabla de programación dinámica:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }
 
        System.out.println("\nGanancia máxima: " + dp[n][presupuesto]);
       
        // Recuperar los paquetes seleccionados
        System.out.println("\nPaquetes seleccionados:");
        int i = n;
        int j = presupuesto;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i-1][j]) {
                System.out.println("Paquete " + i + ": costo=" + costos[i-1] +
                                 ", ganancia=" + ganancias[i-1]);
                j -= costos[i-1];
            }
            i--;
        }
 
        // Análisis de complejidad
        System.out.println("\nAnálisis de complejidad:");
        System.out.println("Tiempo: O(n*P) donde n es el número de paquetes y P es el presupuesto");
        System.out.println("Espacio: O(n*P) para la tabla de programación dinámica");
    }
}