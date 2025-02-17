package clase13;

public class ArbolDecisiones {
    public static void main(String[] args) {
        // Nodos terminales (resultados finales)
        Nodo fraudeDetectado = new Nodo("Fraude detectado", 100, null);
        Nodo fraudeNoDetectado = new Nodo("Fraude no detectado", 0, null);

        // Nivel 2: Respuestas del sistema
        Nodo monitorearTransaccion = new Nodo("Monitorear transacción", 50, new Nodo[]{fraudeDetectado, fraudeNoDetectado});
        Nodo detectarCambioDireccion = new Nodo("Detectar cambio de dirección", 70, new Nodo[]{fraudeDetectado, fraudeNoDetectado});
        Nodo monitorearTransferencia = new Nodo("Monitorear transferencia", 60, new Nodo[]{fraudeDetectado, fraudeNoDetectado});

        // Nivel 1: Acciones del defraudador
        Nodo retirarDinero = new Nodo("Retirar dinero", 0, new Nodo[]{monitorearTransaccion});
        Nodo cambiarDireccion = new Nodo("Cambiar dirección", 0, new Nodo[]{detectarCambioDireccion});
        Nodo transferirInternacional = new Nodo("Transferir internacionalmente", 0, new Nodo[]{monitorearTransferencia});

        // Nodo raíz (inicio del árbol)
        Nodo raiz = new Nodo("Inicio", 0, new Nodo[]{retirarDinero, cambiarDireccion, transferirInternacional});

        // Ejecutar poda alfa-beta
        int mejorValor = PodaAlfaBeta.alfaBeta(raiz, 3, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        System.out.println("Mejor valor para el sistema de detección: " + mejorValor);
    }
}

class Nodo {
    private String accion; // Acción realizada (ej: "Retirar dinero")
    private int valor;     // Valor heurístico (ej: riesgo de fraude)
    private Nodo[] hijos;  // Posibles respuestas o acciones siguientes

    public Nodo(String accion, int valor, Nodo[] hijos) {
        this.accion = accion;
        this.valor = valor;
        this.hijos = hijos;
    }

    public boolean esNodoTerminal() {
        return hijos == null || hijos.length == 0;
    }

    public int obtenerValor() {
        return valor;
    }

    public Nodo[] obtenerHijos() {
        return hijos;
    }

    public String getAccion() {
        return accion;
    }
}

class PodaAlfaBeta {
    public static int alfaBeta(Nodo nodo, int profundidad, int alfa, int beta, boolean esMaximizador) {
        if (nodo.esNodoTerminal() || profundidad == 0) {
            return nodo.obtenerValor();
        }

        if (esMaximizador) {
            int mejorValor = Integer.MIN_VALUE;
            for (Nodo hijo : nodo.obtenerHijos()) {
                int valor = alfaBeta(hijo, profundidad - 1, alfa, beta, false);
                mejorValor = Math.max(mejorValor, valor);
                alfa = Math.max(alfa, mejorValor);
                if (beta <= alfa) {
                    break; // Poda beta
                }
            }
            return mejorValor;
        } else {
            int mejorValor = Integer.MAX_VALUE;
            for (Nodo hijo : nodo.obtenerHijos()) {
                int valor = alfaBeta(hijo, profundidad - 1, alfa, beta, true);
                mejorValor = Math.min(mejorValor, valor);
                beta = Math.min(beta, mejorValor);
                if (beta <= alfa) {
                    break; // Poda alfa
                }
            }
            return mejorValor;
        }
    }
}