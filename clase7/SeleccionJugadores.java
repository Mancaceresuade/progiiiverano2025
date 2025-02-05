package clase7;

public class SeleccionJugadores {
    // Clase que representa un jugador con costo y rendimiento.
    static class Jugador {
        int costo;
        int rendimiento;

        public Jugador(int costo, int rendimiento) {
            this.costo = costo;
            this.rendimiento = rendimiento;
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Definir los jugadores
        Jugador[] jugadores = {
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70),   // Jugador 3
            new Jugador(5, 60),  // Jugador 1
            new Jugador(3, 50),  // Jugador 2
            new Jugador(4, 70)   // Jugador 3
        };
        
        int presupuesto = 8;  // Presupuesto máximo

        // Llamamos a la función que realiza la búsqueda de la mejor combinación
        Resultado mejorResultado = mejorCombinacion(jugadores, presupuesto);
        
        // Mostrar el resultado
        System.out.println("Rendimiento máximo: " + mejorResultado.rendimientoMaximo);
        System.out.println("Costo total: " + mejorResultado.costoTotal);
    }

    // Clase para almacenar el resultado de la mejor combinación
    static class Resultado {
        int rendimientoMaximo;
        int costoTotal;

        public Resultado(int rendimientoMaximo, int costoTotal) {
            this.rendimientoMaximo = rendimientoMaximo;
            this.costoTotal = costoTotal;
        }
    }

    // Función para encontrar la mejor combinación
    static Resultado mejorCombinacion(Jugador[] jugadores, int presupuesto) {
        int n = jugadores.length;
        int mejorRendimiento = 0;
        int mejorCosto = 0;

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
            int costoTotal = 0;
            int rendimientoTotal = 0;

            // Recorremos cada bit de la combinación actual
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                    costoTotal += jugadores[j].costo;
                    rendimientoTotal += jugadores[j].rendimiento;
                }
            }

            // Verificar si el costo total no excede el presupuesto y si el rendimiento es mejor
            if (costoTotal <= presupuesto && rendimientoTotal > mejorRendimiento) {
                mejorRendimiento = rendimientoTotal;
                mejorCosto = costoTotal;
            }
        }

        // Retornar el mejor resultado
        return new Resultado(mejorRendimiento, mejorCosto);
    }
}
