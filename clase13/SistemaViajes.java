package clase13;

import java.util.*;

class Ruta {
    String ciudad;
    int costo;
    List<String> camino;

    Ruta(String ciudad, int costo, List<String> camino) {
        this.ciudad = ciudad;
        this.costo = costo;
        this.camino = new ArrayList<>(camino);
        this.camino.add(ciudad);
    }
}

class Grafo {
    private final Map<String, List<Ruta>> adyacencias = new HashMap<>();

    void agregarRuta(String origen, String destino, int costo) {
        adyacencias.putIfAbsent(origen, new ArrayList<>());
        adyacencias.get(origen).add(new Ruta(destino, costo, new ArrayList<>()));
    }

    void encontrarRutaMasBarata(String origen, String destino) {
        PriorityQueue<Ruta> cola = new PriorityQueue<>(Comparator.comparingInt(r -> r.costo));
        cola.add(new Ruta(origen, 0, new ArrayList<>())) ;
        Set<String> visitados = new HashSet<>();

        while (!cola.isEmpty()) {
            Ruta actual = cola.poll();
            
            if (actual.ciudad.equals(destino)) {
                System.out.println("Costo mínimo: " + actual.costo);
                System.out.println("Itinerario: " + String.join(" -> ", actual.camino));
                return;
            }
            
            if (!visitados.contains(actual.ciudad)) {
                visitados.add(actual.ciudad);
                for (Ruta vecino : adyacencias.getOrDefault(actual.ciudad, new ArrayList<>())) {
                    if (!visitados.contains(vecino.ciudad)) {
                        cola.add(new Ruta(vecino.ciudad, actual.costo + vecino.costo, actual.camino));
                    }
                }
            }
        }
        System.out.println("No se encontró ruta de " + origen + " a " + destino);
    }
}

public class SistemaViajes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();
        
        grafo.agregarRuta("A", "B", 100);
        grafo.agregarRuta("A", "C", 200);
        grafo.agregarRuta("B", "C", 50);
        grafo.agregarRuta("B", "D", 150);
        grafo.agregarRuta("C", "D", 100);
        
        System.out.print("Ingrese ciudad de origen: ");
        String origen = scanner.nextLine();
        System.out.print("Ingrese ciudad de destino: ");
        String destino = scanner.nextLine();
        
        grafo.encontrarRutaMasBarata(origen, destino);
        scanner.close();
    }
}
