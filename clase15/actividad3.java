package clase15;
import java.util.ArrayList;
import java.util.List;
 
class Sucursal {
    String nombre;
    int monto; // Positivo para cobro, negativo para pago
 
    public Sucursal(String nombre, int monto) {
        this.nombre = nombre;
        this.monto = monto;
    }
 
    @Override
    public String toString() {
        return "Sucursal{" +
                "nombre='" + nombre + '\'' +
                ", monto=" + monto +
                '}';
    }
}
 
public class actividad3 {
 
    public static List<String> planificarRecorrido(List<Sucursal> sucursales, int saldoInicial) {
        List<String> recorrido = new ArrayList<>();
        int saldoActual = saldoInicial;
        List<Sucursal> sucursalesVisitadas = new ArrayList<>();
 
        //Mientras haya sucursales sin visitar
        while (sucursalesVisitadas.size() < sucursales.size()) {
            Sucursal mejorOpcion = null;
            int maxGanancia = Integer.MIN_VALUE; // Inicializar con el peor valor posible
 
            // Encontrar la mejor opción (mayor ganancia y factible) entre las no visitadas.
            for (Sucursal sucursal : sucursales) {
                //Si la sucursal ya fue visitada, continuar
                if (sucursalesVisitadas.contains(sucursal)) {
                    continue;
                }
 
                // Si hay saldo suficiente, o si la sucursal implica un cobro.
                if (saldoActual + sucursal.monto >= 0) {
                    //Priorizar los cobros. Si es un cobro, se le asigna un valor mas grande
                    if (sucursal.monto > 0 && sucursal.monto > maxGanancia) {
                            //Se encontro una mejor opcion de cobro
                            maxGanancia = sucursal.monto;
                            mejorOpcion = sucursal;
 
                    } else if(mejorOpcion == null || mejorOpcion.monto < 0){ //Si no se encontro opcion de cobro, elegir la que menos haga perder
                        if (sucursal.monto > maxGanancia) {
                            maxGanancia = sucursal.monto; //Es un pago, pero el menos negativo
                            mejorOpcion = sucursal;
                        }
                    }
                }
            }
 
            // Si no se encontro una opcion viable, se termina
            if (mejorOpcion == null) {
                System.out.println("No se pudo completar el recorrido. Saldo insuficiente.");
                return recorrido;
            }
 
            // Se encontro una opcion
            saldoActual += mejorOpcion.monto;
            recorrido.add(mejorOpcion.nombre);
            sucursalesVisitadas.add(mejorOpcion); // Marcar la sucursal como visitada.
 
        }
 
        return recorrido;
    }
    public static void main(String[] args) {
        List<Sucursal> sucursales = new ArrayList<>();
        sucursales.add(new Sucursal("Sucursal A", 500));
        sucursales.add(new Sucursal("Sucursal B", -200));
        sucursales.add(new Sucursal("Sucursal C", 300));
        sucursales.add(new Sucursal("Sucursal D", -100));
        sucursales.add(new Sucursal("Sucursal E", 400));
        sucursales.add(new Sucursal("Sucursal F", -300));
        sucursales.add(new Sucursal("Sucursal G", 600));
        sucursales.add(new Sucursal("Sucursal H", -150));
 
 
        int saldoInicial = 50; // Ejemplo con saldo inicial
 
        List<String> recorrido = planificarRecorrido(sucursales, saldoInicial);
 
        if (!recorrido.isEmpty()) {
            System.out.println("Recorrido planificado:");
            System.out.println(recorrido);
        }
       
    }
}