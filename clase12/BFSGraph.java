import java.util.*;

public class BFSGraph {
    private Map<Integer, List<Integer>> grafo;

    public BFSGraph() {
        this.grafo = new HashMap<>();
    }

    public void agregarArista(int origen, int destino) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(destino);
    }

    public void BFS(int nodoInicial) {
        Queue<Integer> cola = new LinkedList<>();
        Set<Integer> visitado = new HashSet<>();
        
        cola.add(nodoInicial);
        visitado.add(nodoInicial);
        
        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.println("Visitando nodo: " + nodo);
            
            for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
                if (!visitado.contains(vecino)) {
                    visitado.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraph grafo = new BFSGraph();
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);
        
        System.out.println("Recorrido BFS desde el nodo 0:");
        grafo.BFS(0);
    }
}
