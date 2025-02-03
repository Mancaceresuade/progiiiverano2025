package clase4;

import java.util.ArrayList;

public class Clase4Actividad4 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = cargarDatos();
        System.out.println(obtenerMayores(numeros, 4));
    }

    private static ArrayList<Integer> obtenerMayores(ArrayList<Integer> numeros, int cantidad) {
        return obtenerMayores(numeros, cantidad, 0, numeros.size());
    }    
    private static ArrayList<Integer> obtenerMayores(ArrayList<Integer> numeros, int cantidad, int i, int f) {
        // caso base
        // mitad
        // izq
        // der
        // combinar
        return null;
    }

    private static ArrayList<Integer> cargarDatos() {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(12);
        numeros.add(20);
        numeros.add(10);
        numeros.add(15);
        return numeros;
    }

}