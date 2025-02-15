import java.util.*;

class Almacen {
    int id;
    String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }

}

class Grafo {
    private Map<Almacen, List<Almacen>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    public void agregarAlmacen(Almacen almacen) {
        listaAdyacencia.putIfAbsent(almacen, new ArrayList<>());
    }

    public void conectarAlmacenes(Almacen almacen1, Almacen almacen2) {
        listaAdyacencia.get(almacen1).add(almacen2);
        listaAdyacencia.get(almacen2).add(almacen1); // Si el grafo es no dirigido
    }

    public void DFS(Almacen inicio) {
        Set<Almacen> visitados = new HashSet<>();
        DFSUtil(inicio, visitados);
    }

    private void DFSUtil(Almacen actual, Set<Almacen> visitados) {
        visitados.add(actual);
        System.out.print(actual + " ");

        for (Almacen vecino : listaAdyacencia.get(actual)) {
            if (!visitados.contains(vecino)) {
                DFSUtil(vecino, visitados);
            }
        }
    }

    public void BFS(Almacen inicio) {
        Set<Almacen> visitados = new HashSet<>();
        Queue<Almacen> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Almacen actual = cola.poll();
            System.out.print(actual + " ");

            for (Almacen vecino : listaAdyacencia.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Almacen almacen1 = new Almacen(1, "Almacen A");
        Almacen almacen2 = new Almacen(2, "Almacen B");
        Almacen almacen3 = new Almacen(3, "Almacen C");
        Almacen almacen4 = new Almacen(4, "Almacen D");
        Almacen almacen5 = new Almacen(5, "Almacen E");

        grafo.agregarAlmacen(almacen1);
        grafo.agregarAlmacen(almacen2);
        grafo.agregarAlmacen(almacen3);
        grafo.agregarAlmacen(almacen4);
        grafo.agregarAlmacen(almacen5);

        grafo.conectarAlmacenes(almacen1, almacen2);
        grafo.conectarAlmacenes(almacen1, almacen3);
        grafo.conectarAlmacenes(almacen2, almacen4);
        grafo.conectarAlmacenes(almacen3, almacen5);

        System.out.println("Recorrido DFS desde Almacen A:");
        grafo.DFS(almacen1);
        System.out.println();

        System.out.println("Recorrido BFS desde Almacen A:");
        grafo.BFS(almacen1);
        System.out.println();

        // Ejemplo de uso de Comparable: Ordenar almacenes por ID
        List<Almacen> almacenes = new ArrayList<>();
        almacenes.add(almacen3);
        almacenes.add(almacen1);
        almacenes.add(almacen5);
        almacenes.add(almacen2);
        almacenes.add(almacen4);

        System.out.println("Almacenes desordenados:");
        for (Almacen a : almacenes) {
            System.out.println(a);
        }

        Collections.sort(almacenes);

        System.out.println("\nAlmacenes ordenados por ID:");
        for (Almacen a : almacenes) {
            System.out.println(a);
        }
    }
}