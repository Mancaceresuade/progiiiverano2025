import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

class Cliente {
    int idCliente;
    String nombre;

    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}

class Resultado {
    int idCliente;
    String nombreCliente;
    double sumaImportes;

    public Resultado(int idCliente, String nombreCliente, double sumaImportes) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.sumaImportes = sumaImportes;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombreCliente + " (ID: " + idCliente + "), Suma de Importes: " + sumaImportes;
    }
}

public class Facturacion {
    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 101, 100.0));
        facturas.add(new Factura(2, 102, 200.0));
        facturas.add(new Factura(3, 101, 150.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(101, "Cliente A"));
        clientes.add(new Cliente(102, "Cliente B"));

        Map<Integer, Cliente> clienteMap = new HashMap<>();
        for (Cliente cliente : clientes) {
            clienteMap.put(cliente.idCliente, cliente);
        }

        Map<Integer, Double> sumaImportesMap = new TreeMap<>();
        for (Factura factura : facturas) {
            sumaImportesMap.put(factura.idCliente, sumaImportesMap.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        List<Resultado> resultados = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : sumaImportesMap.entrySet()) {
            int idCliente = entry.getKey();
            Cliente cliente = clienteMap.get(idCliente);
            resultados.add(new Resultado(idCliente, cliente.nombre, entry.getValue()));
        }

        for (Resultado resultado : resultados) {
            System.out.println(resultado);
        }
    }
}