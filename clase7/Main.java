import java.util.ArrayList;

public class Main {
    private static class Jugador {
        int costo;
        int rendimiento;

        Jugador(int costo, int rendimiento) {
            this.costo = costo;
            this.rendimiento = rendimiento;
        }
    }

    public static int rendimientoMaximo(int[][] presupuesto) {
        return presupuesto[presupuesto.length - 1][presupuesto[0].length - 1];
    }

    public static void generarMatrizDeRendimientos(Jugador[] jugadores, int presupuesto, int[][] presupuestos){
        for (int i = 1; i <= jugadores.length; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (jugadores[i - 1].costo <= j) {
                    presupuestos[i][j] = Math.max(presupuestos[i - 1][j],
                            presupuestos[i - 1][j - jugadores[i - 1].costo] + jugadores[i - 1].rendimiento);
                } else {
                    presupuestos[i][j] = presupuestos[i - 1][j];
                }
            }
        }
    }

    public static ArrayList<Jugador> obtenerJugadores(Jugador[] jugadores, int[][] presupuestos) {
        int presupuesto = presupuestos[0].length - 1;
        ArrayList<Jugador> jugadoresElegidos = new ArrayList<Jugador>();

        for (int i = presupuestos.length - 1; i > 0 && presupuesto > 0; i--) {
            Jugador jugador = jugadores[i - 1];

            if (
                    presupuestos[i][presupuestos[0].length - 1] != presupuestos[i - 1][presupuestos[0].length - 1] 
                    && presupuesto - jugador.costo >= 0
            ) {
                jugadoresElegidos.add(jugador);
                presupuesto -= jugador.costo;
            }
        }

        return jugadoresElegidos;
    }

    public static void optimizarRendimientos(Jugador[] jugadores, int presupuesto){
        int[][] presupuestos = new int[jugadores.length + 1][presupuesto + 1];

        generarMatrizDeRendimientos(jugadores, presupuesto, presupuestos);

        int rendimiento = rendimientoMaximo(presupuestos);
        ArrayList<Jugador> jugadoresElegidos = obtenerJugadores(jugadores, presupuestos);
        System.out.println(jugadoresElegidos);
        System.out.println(rendimiento);

        for (int i = 0; i < presupuestos.length; i++) {
            for (int j = 0; j < presupuestos[0].length; j++) {
                System.out.print(presupuestos[i][j]);
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        int presupuesto = 8;
        Jugador[] jugadores = {
                new Jugador(5, 60),
                new Jugador(3, 50),
                new Jugador(4, 70),
        };
        optimizarRendimientos(jugadores, presupuesto);
    }
}