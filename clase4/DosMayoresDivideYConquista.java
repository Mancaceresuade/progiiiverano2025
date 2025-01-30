package clase4;

public class DosMayoresDivideYConquista {

    // Clase para almacenar los dos números mayores
    static class Resultado {
        int mayor;
        int segundoMayor;

        Resultado(int mayor, int segundoMayor) {
            this.mayor = mayor;
            this.segundoMayor = segundoMayor;
        }
    }

    // Función principal para encontrar los dos números mayores
    public static Resultado encontrarDosMayores(int[] lista, int inicio, int fin) {
        // Caso base: si la lista tiene solo un elemento
        if (inicio == fin) {
            return new Resultado(lista[inicio], Integer.MIN_VALUE);
        }

        // Caso base: si la lista tiene dos elementos
        if (fin == inicio + 1) {
            if (lista[inicio] > lista[fin]) {
                return new Resultado(lista[inicio], lista[fin]);
            } else {
                return new Resultado(lista[fin], lista[inicio]);
            }
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;

        // Conquistar: encontrar los dos mayores en cada mitad
        Resultado izquierda = encontrarDosMayores(lista, inicio, medio);
        Resultado derecha = encontrarDosMayores(lista, medio + 1, fin);

        // Combinar: comparar los resultados de las dos mitades
        return combinar(izquierda, derecha);
    }

    // Función para combinar los resultados de las dos mitades
    private static Resultado combinar(Resultado izquierda, Resultado derecha) {
        int mayor, segundoMayor;

        // Determinar el mayor entre las dos mitades
        if (izquierda.mayor > derecha.mayor) {
            mayor = izquierda.mayor;
            segundoMayor = Math.max(izquierda.segundoMayor, derecha.mayor);
        } else {
            mayor = derecha.mayor;
            segundoMayor = Math.max(derecha.segundoMayor, izquierda.mayor);
        }

        return new Resultado(mayor, segundoMayor);
    }

    public static void main(String[] args) {
        int[] lista = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Resultado resultado = encontrarDosMayores(lista, 0, lista.length - 1);

        System.out.println("El número mayor es: " + resultado.mayor);
        System.out.println("El segundo número mayor es: " + resultado.segundoMayor);
    }
}