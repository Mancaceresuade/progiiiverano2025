public abstract class Persona {
    protected String id;
    protected String nombre;
    public Persona(String id,String nombre)    {
        this.id = id;
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + "]";
    }
    
}
