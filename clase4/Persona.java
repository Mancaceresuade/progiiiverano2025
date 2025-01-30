package clase4;

public class Persona {
    private int id;
    private String nombre;
    private int scoring;

    public Persona(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Scoring: " + scoring;
    }
}
