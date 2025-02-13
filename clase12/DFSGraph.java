import java.util.*;

public class DFSGraph {
    private Map<Integer, List<Integer>> grafo;

    public DFSGraph() {
        this.grafo = new HashMap<>();
    }

    public void agregarArista(int origen, int destino) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(destino);
    }

    public void DFS(int nodoInicial) {
        Set<Integer> visitado = new HashSet<>();
        DFSRecursivo(nodoInicial, visitado);
    }

    private void DFSRecursivo(int nodo, Set<Integer> visitado) {
        visitado.add(nodo);
        System.out.println("Visitando nodo: " + nodo);
        
        for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
            if (!visitado.contains(vecino)) {
                DFSRecursivo(vecino, visitado);
            }
        }
    }

    public static void main(String[] args) {
        DFSGraph grafo = new DFSGraph();
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(0, 4);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 5);
        grafo.agregarArista(2, 6);
        grafo.agregarArista(5, 4);
        
        System.out.println("Recorrido DFS desde el nodo 0:");
        grafo.DFS(0);
    }
}
