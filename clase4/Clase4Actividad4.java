package clase4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Clase4Actividad4 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = cargarDatos();
        System.out.println(obtenerMayores(numeros, 4));
    }

    private static ArrayList<Integer> obtenerMayores(ArrayList<Integer> numeros, int cantidad) {
        return obtenerMayores(numeros, cantidad, 0, numeros.size());
    }

    private static ArrayList<Integer> obtenerMayores(ArrayList<Integer> numeros, int cantidad, int i, int f) {
        ArrayList<Integer> resultado = casoBase(numeros, cantidad, i, f);
        if (resultado != null) {
            return resultado;
        }
        int mitad = (f + i) / 2;
        ArrayList<Integer> izq = obtenerMayores(numeros, cantidad, i, mitad);
        ArrayList<Integer> der = obtenerMayores(numeros, cantidad, mitad, f);
        return combinar(izq, der);
    }

    private static ArrayList<Integer> combinar(ArrayList<Integer> izq, ArrayList<Integer> der) {
        PriorityQueue<Integer> resultado = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer integer : izq) {
            resultado.offer(integer);
        }
        for( Integer integer : der) {
            resultado.offer(integer);
        }
        return new ArrayList<>(resultado);
    }

    private static ArrayList<Integer> casoBase(ArrayList<Integer> numeros, int cantidad, int i, int f) {
        // vacio
        if (numeros == null || i <= f) {
            return new ArrayList<>();
        }
        // un elemento
        if (f - i == 1) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(numeros.get(1));
            return res;
        }
        // menor o igual a la cantidad
        if (f - i <= cantidad) {
            ArrayList<Integer> resultado = new ArrayList<>(numeros.subList(i, f));
            Collections.sort(resultado, Collections.reverseOrder());
            return resultado;
        }
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