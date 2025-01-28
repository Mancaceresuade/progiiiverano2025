public class Empleado extends Persona{
    private String numeroLegajo;
    public Empleado(String id, String nombre,
    String numeroLegajo) {
        super(id, nombre);
        this.numeroLegajo = numeroLegajo;
    }
    @Override
    public String toString() {
        return this.id + " " + this.nombre + " " +
                "Empleado [numeroLegajo=" + numeroLegajo + "]";
    }
    
    
}
