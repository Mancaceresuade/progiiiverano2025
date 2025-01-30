package clase4;

import java.util.ArrayList;
import java.util.List;

public class EjercicioClase4 {

    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Juan", 85));
        personas.add(new Persona(2, "María", 90));
        personas.add(new Persona(3, "Pedro", 78));
        personas.add(new Persona(4, "Lucía", 95));
        personas.add(new Persona(5, "Carlos", 80));
        personas.add(new Persona(6, "Ana", 88));
        personas.add(new Persona(7, "Luis", 92));
        personas.add(new Persona(8, "Sofía", 75));
        personas.add(new Persona(9, "Marta", 50));
        personas.add(new Persona(10, "Jorge", 70));

        System.out.println("Scoring máximo: " + buscarScoringMaximo(personas, 0, personas.size() - 1));
    }

    private static Persona buscarScoringMaximo(List<Persona> personas, int inicio, int fin) {
        if (inicio == fin) {
            return personas.get(inicio);
        }

        int medio = (inicio + fin) / 2;
        Persona maxIzquierda = buscarScoringMaximo(personas, inicio, medio);
        Persona maxDerecha = buscarScoringMaximo(personas, medio + 1, fin);
 
        return maxIzquierda.scoring > maxDerecha.scoring ? maxIzquierda : maxDerecha;
 
        /*
        if (maxIzquierda.scoring >= maxDerecha.scoring) {
            return maxIzquierda;
        } else {
            return maxDerecha;
        }
        */    
    }

    static class Persona {
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
}