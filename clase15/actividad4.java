package clase15;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
 
class Nodo {
    String nombre;
    double montoCripto; // Positivo para cobro, negativo para pago
    double tasaCambio;  // Tasa de cambio a dólares en el momento de la visita
 
    public Nodo(String nombre, double montoCripto, double tasaCambio) {
        this.nombre = nombre;
        this.montoCripto = montoCripto;
        this.tasaCambio = tasaCambio;
    }
 
    @Override
    public String toString() {
        return "Nodo{" +
                "nombre='" + nombre + '\'' +
                ", montoCripto=" + montoCripto +
                ", tasaCambio=" + tasaCambio +
                '}';
    }
}
 
public class actividad4 {
 
    public static List<String> planificarRecorrido(List<Nodo> nodos, double saldoInicialCripto, double tasaCambioInicial) {
        List<String> recorrido = new ArrayList<>();
        double saldoActualCripto = saldoInicialCripto;
        double saldoActualDolares = saldoInicialCripto * tasaCambioInicial; // Calcular saldo inicial en dólares
        List<Nodo> nodosRestantes = new ArrayList<>(nodos);

        
        // Ordenar los nodos por ganancia potencial en dólares (heurística greedy)
        Collections.sort(nodosRestantes, Comparator.comparingDouble(n -> - (n.montoCripto * n.tasaCambio) )); // Orden descendente
 
        while (!nodosRestantes.isEmpty()) {
            Nodo mejorOpcion = null;
            double mejorGananciaDolares = Double.NEGATIVE_INFINITY; // Inicializar con el peor valor
 
            // Encontrar el mejor nodo a visitar (mayor ganancia en dólares y factible)
            for (Nodo nodo : nodosRestantes) {
                double saldoProyectadoCripto = saldoActualCripto + nodo.montoCripto;
                //Simular volatilidad antes de calcular la ganancia proyectada en dólares
                double tasaProyectada = simularVolatilidad(nodo.tasaCambio);
                double gananciaProyectadaDolares =  nodo.montoCripto * tasaProyectada;
 
                if (saldoProyectadoCripto >= 0) { // Verificar factibilidad
                   if(nodo.montoCripto > 0){ //Si es un cobro, lo priorizamos
                        mejorOpcion = nodo;
                        break; // Salir del bucle, ya que este es el mejor caso
                    } else if (gananciaProyectadaDolares > mejorGananciaDolares) { //Si no es un cobro, buscar la mejor opcion
                        mejorGananciaDolares = gananciaProyectadaDolares;
                        mejorOpcion = nodo;
                    }
                }
            }
 
            if (mejorOpcion == null) {
                System.out.println("No se pudo completar el recorrido. Saldo insuficiente.");
                return new ArrayList<>(); // Devolver lista vacía
            }
 
            // Actualizar el estado y agregar al recorrido
            saldoActualCripto += mejorOpcion.montoCripto;
            saldoActualDolares += mejorOpcion.montoCripto * mejorOpcion.tasaCambio; // Usar tasa del nodo
            recorrido.add(mejorOpcion.nombre);
            nodosRestantes.remove(mejorOpcion);
        }
        System.out.println("Saldo Final en dolares: " + saldoActualDolares);
        return recorrido;
    }
   
    //Simulacion de la volatilidad.
    private static double simularVolatilidad(double tasaActual) {
        Random random = new Random();
        double fluctuacion = 0.05; // 5% de fluctuación máxima
        double cambio = (random.nextDouble() * 2 * fluctuacion) - fluctuacion; // [-0.05, 0.05]
        return tasaActual * (1 + cambio);
    }
 
    public static void main(String[] args) {
        List<Nodo> nodos = new ArrayList<>();
        nodos.add(new Nodo("Nodo A", 5.0, 10.0));   // Cobro 5 cripto, tasa 10 USD/cripto
        nodos.add(new Nodo("Nodo B", -2.0, 11.0));  // Pago 2 cripto, tasa 11 USD/cripto
        nodos.add(new Nodo("Nodo C", 3.0, 9.5));    // Cobro 3 cripto
        nodos.add(new Nodo("Nodo D", -1.0, 10.5));  // Pago 1 cripto
        nodos.add(new Nodo("Nodo E", 4.0, 9.8));
        nodos.add(new Nodo("Nodo F", -2.5, 10.2));
        nodos.add(new Nodo("Nodo G", 6.0, 10.3)); //Agrego mas nodos
        nodos.add(new Nodo("Nodo H", -3.5, 9.7));
        nodos.add(new Nodo("Nodo I", 2, 10.1));
 
        double saldoInicialCripto = 2.0; // Ejemplo: El agente comienza con 2 criptomonedas
        double tasaCambioInicial = 10.0; // Tasa de cambio inicial
 
        List<String> recorrido = planificarRecorrido(nodos, saldoInicialCripto, tasaCambioInicial);
 
        if (!recorrido.isEmpty()) {
            System.out.println("Recorrido planificado (saldo inicial cripto: " + saldoInicialCripto +
                    ", tasa inicial: " + tasaCambioInicial + "):");
            System.out.println(recorrido);
        }
       
        saldoInicialCripto = 0.1;
        recorrido = planificarRecorrido(nodos, saldoInicialCripto, tasaCambioInicial);
 
        if (!recorrido.isEmpty()) {
            System.out.println("Recorrido planificado (saldo inicial cripto: " + saldoInicialCripto +
                    ", tasa inicial: " + tasaCambioInicial + "):");
            System.out.println(recorrido);
        }
    }
}