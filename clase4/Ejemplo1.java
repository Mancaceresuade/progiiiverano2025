package clase4;

public class Ejemplo1 {
    public static void main(String[] args) {
        int[] numeros = { 3 , 5 };
        System.out.println(suma(numeros));
    }

    private static int suma(int[] numeros) {
        return suma(numeros, 0, numeros.length);
    }

    private static int suma(int[] numeros, int i, int f) {
        if (i == f - 1)
            return numeros[i];
        int mitad = (f + i) / 2;
        int izq = suma(numeros, i, mitad);
        int der = suma(numeros, mitad, f);
        return izq + der;
    }
}