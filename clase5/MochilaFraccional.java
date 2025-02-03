package clase5;


import java.util.Arrays;

public class MochilaFraccional {

    // Clase para representar un objeto con su valor y peso
    static class Item {
        double value, weight, ratio;

        Item(double value, double weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = value / weight;
        }
    }

    public static double fractionalKnapsack(int W, Item[] items) {
        // Ordenar los objetos por la relación valor/peso en orden descendente
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double maxValue = 0.0;

        for (Item item : items) {
            if (W == 0) break; // Si la mochila está llena, terminar

            if (item.weight <= W) {
                // Tomar el objeto completo
                maxValue += item.value;
                W -= item.weight;
            } else {
                // Tomar solo la fracción del objeto que cabe en la mochila
                maxValue += item.value * ((double) W / item.weight);
                W = 0;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(30, 10),
            new Item(50, 20),
            new Item(60, 30)
        };

        int W = 50; // Capacidad de la mochila

        System.out.println("Valor máximo obtenido = " + fractionalKnapsack(W, items));
    }
}
