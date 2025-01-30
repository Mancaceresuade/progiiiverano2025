package clase4;

public class Ejemplo {
    public static void main(String[] args) {
        int n = 10000; // Probar con 100000 elementos
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeros[i] = i;
        }
        System.out.println(suma(numeros));
    }

    private static int suma(int[] numeros) {
        return suma(numeros, 0);
    }

    private static int suma(int[] numeros, int i) {
        if (i == numeros.length - 1)
            return numeros[numeros.length - 1];
        return numeros[i] + suma(numeros, i + 1);
    }
}