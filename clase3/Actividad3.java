public class Actividad3 {
 
    public static int pivot(int[] S, int inicio, int fin) {
        int p = S[inicio]; // Seleccionar el pivote como el primer elemento
        int k = inicio + 1; // Inicializar k
        int l = fin; // Inicializar l
 
        // Encontrar el primer elemento mayor que el pivote
        while (k <= fin && S[k] <= p) { //Mientras que no se haya llegado al final y los elementos sean menores o iguales que el pivote
            k++;
        }
        //Encontrar el primer elemento desde el final que sea menor que el pivote
        while (S[l] > p) { //Mientras que los elementos desde el final sean mayores que el pivote
            l--;
        }
 
        // Intercambiar elementos hasta que k y l se crucen
        while (k < l) {
            // Intercambiar S[k] y S[l]
            int aux = S[k];
            S[k] = S[l];
            S[l] = aux;
 
            // Mover k hacia la derecha hasta encontrar un elemento mayor que el pivote
            while (S[k] <= p) {
                k++;
            }
 
            // Mover l hacia la izquierda hasta encontrar un elemento menor que el pivote
            while (S[l] > p) {
                l--;
            }
        }
 
        // Colocar el pivote en su posición correcta
        int aux = S[inicio];
        S[inicio] = S[l];
        S[l] = aux;
 
        // Devolver la posición del pivote
        return l;
    }
 
    public static void main(String[] args) {
        // Ejemplo de uso
        int[] S = {15, 22, 13, 27, 12, 10, 20, 25};
        int inicio = 0;
        int fin = S.length - 1;
 
        System.out.println("Arreglo original:");
        printArray(S);
 
        int pivotIndex = pivot(S, inicio, fin);
 
        System.out.println("\nArreglo después de pivotear:");
        printArray(S);
        System.out.println("\nÍndice del pivote: " + pivotIndex);
    }
   
    // Método auxiliar para imprimir el arreglo
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}