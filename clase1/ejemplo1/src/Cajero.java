public class Cajero extends Persona implements CerrarCaja{

    public Cajero(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void cerrarCaja() {
        System.out.println("Cerrando caja");
    }
    
}
