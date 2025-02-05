package clase6;

import java.util.ArrayList;

class Grafo {
    private int[][] matriz;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matriz = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 1;
        }
    }

    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 0;
        }
    }

    public boolean existeArista(int origen, int destino) {
        return matriz[origen][destino] == 1;
    }

    public void listarAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            System.out.print("Nodos adyacentes a " + vertice + ": ");
            ArrayList<Integer> adyacentes = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    adyacentes.add(i);
                }
            }
            System.out.println(adyacentes.isEmpty() ? "Ninguno" : adyacentes);
        }
    }

    public int gradoSalida(int vertice) {
        int grado = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matriz[vertice][i] == 1) {
                grado++;
            }
        }
        return grado;
    }

    public int gradoEntrada(int vertice) {
        int grado = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matriz[i][vertice] == 1) {
                grado++;
            }
        }
        return grado;
    }

    public void mostrarMatriz() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 3);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(3, 4);
        grafo.mostrarMatriz();
        System.out.println("\n¿Existe arista (0 → 1)? " + grafo.existeArista(0, 1));
        System.out.println("¿Existe arista (1 → 3)? " + grafo.existeArista(1, 3));
        grafo.listarAdyacentes(0);
        grafo.listarAdyacentes(2);
        System.out.println("\nGrado de salida del nodo 0: " + grafo.gradoSalida(0));
        System.out.println("Grado de entrada del nodo 4: " + grafo.gradoEntrada(4));
        grafo.eliminarArista(0, 3);
        System.out.println("\nMatriz de Adyacencia después de eliminar arista (0 → 3):");
        grafo.mostrarMatriz();
    }
}
 