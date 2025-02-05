package clase7;

import java.util.Arrays;
import java.util.Comparator;

public class SeleccionJugadoresGreedy {
    // Clase que representa un jugador con costo, rendimiento y la relación rendimiento/costo
    static class Jugador {
        int costo;
        int rendimiento;
        double relacion;

        public Jugador(int costo, int rendimiento) {
            this.costo = costo;
            this.rendimiento = rendimiento;
            this.relacion = (double) rendimiento / costo;
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Definir los jugadores
        Jugador[] jugadores = {
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70)   // Jugador 3
        };

        int presupuesto = 8;  // Presupuesto máximo

        // Llamar a la función que selecciona jugadores usando el enfoque greedy
        int rendimientoMaximo = seleccionGreedy(jugadores, presupuesto);

        // Mostrar el resultado
        System.out.println("Rendimiento máximo usando greedy: " + rendimientoMaximo);
    }

    // Función para seleccionar jugadores usando técnica greedy
    static int seleccionGreedy(Jugador[] jugadores, int presupuesto) {
        // Ordenamos los jugadores por la relación rendimiento/costo de mayor a menor
        Arrays.sort(jugadores, Comparator.comparingDouble(j -> -j.relacion));

        int rendimientoTotal = 0;
        int costoTotal = 0;

        // Seleccionar jugadores mientras el presupuesto lo permita
        for (Jugador jugador : jugadores) {
            if (costoTotal + jugador.costo <= presupuesto) {
                costoTotal += jugador.costo;
                rendimientoTotal += jugador.rendimiento;
            }
        }

        // Retornar el rendimiento total
        return rendimientoTotal;
    }
}
