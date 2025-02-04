package clase5;

import java.util.*;

class Arista implements Comparable<Arista> {
    int origen, destino, peso;

    public Arista(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista o) {
        return this.peso - o.peso;
    }

    /*
    @Override
    public int compareTo(Arista otra) {
        return this.peso - otra.peso;
    }
    */
}

class UnionFind {
    private int[] padre, rango;

    public UnionFind(int n) {
        padre = new int[n];
        rango = new int[n];
        for (int i = 0; i < n; i++) {
            padre[i] = i;
            rango[i] = 0;
        }
    }

    public int encontrar(int u) {
        if (padre[u] != u) {
            padre[u] = encontrar(padre[u]); // Compresión de ruta
        }
        return padre[u];
    }

    public void unir(int u, int v) {
        int raizU = encontrar(u);
        int raizV = encontrar(v);

        if (raizU != raizV) {
            if (rango[raizU] < rango[raizV]) {
                padre[raizU] = raizV;
            } else if (rango[raizU] > rango[raizV]) {
                padre[raizV] = raizU;
            } else {
                padre[raizV] = raizU;
                rango[raizU]++;
            }
        }
    }
}

public class Kruskal {

    public static void main(String[] args) {
        int V = 4; // Número de vértices
        List<Arista> aristas = new ArrayList<>();

        // Agregar aristas al grafo
        aristas.add(new Arista(0, 1, 1));
        aristas.add(new Arista(0, 2, 4));
        aristas.add(new Arista(1, 3, 3));
        aristas.add(new Arista(2, 3, 2));

        // Crear el árbol de recubrimiento mínimo (MST) usando el algoritmo de Kruskal
        List<Arista> mst = kruskal(V, aristas);

        System.out.println("Aristas en el árbol de recubrimiento mínimo:");
        for (Arista arista : mst) {
            System.out.println(arista.origen + " -- " + arista.destino + " == " + arista.peso);
        }
    }

    public static List<Arista> kruskal(int V, List<Arista> aristas) {
        Collections.sort(aristas); // Ordenar aristas por peso
        UnionFind uf = new UnionFind(V);

        List<Arista> resultado = new ArrayList<>();
        for (Arista arista : aristas) {
            int origenRaiz = uf.encontrar(arista.origen);
            int destinoRaiz = uf.encontrar(arista.destino);

            // Si origen y destino están en diferentes componentes, se unen
            if (origenRaiz != destinoRaiz) {
                resultado.add(arista);
                uf.unir(origenRaiz, destinoRaiz);
            }

            // Si ya tenemos V-1 aristas, terminamos
            if (resultado.size() == V - 1) {
                break;
            }
        }
        return resultado;
    }
}
