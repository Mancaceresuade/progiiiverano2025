package clase6;

import java.util.ArrayList;
import java.util.TreeMap;

public class Clase6 {
    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        TreeMap<Integer, ArrayList<Integer>> relaciones = new TreeMap<Integer, ArrayList<Integer>>();

        Usuario nico = new Usuario(0, "Nico");
        Usuario usuario1 = new Usuario(0, "Nico 2");
        Usuario usuario2 = new Usuario(0, "Nico 3");
        Usuario usuario3 = new Usuario(0, "Nico 4");
        Usuario usuario4 = new Usuario(0, "Nico 5");

        usuarios.add(nico);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);

        // Agregar listas de adyacencia para cada vértice
        for (int i = 0; i < usuarios.size(); i++) {
            relaciones.put(i, new ArrayList<Integer>());
        }

        // Agregar aristas
        relaciones.get(0).add(2); // A - C
        relaciones.get(0).add(3); // B - D
        relaciones.get(2).add(3); // C - D
        relaciones.get(3).add(1); // C - D

        for (int i = 0; i < usuarios.size(); i++) {

            if (relaciones.get(i).size() <= 0) {
                System.out.print(String.format("El usuario %s no sigue a nadie actualmente", usuarios.get(i).getNombre()));
            } else {
                System.out.print(String.format("El usuario %s sigue a los usuarios: ", usuarios.get(i).getNombre()));
                for (int j = 0; j < relaciones.get(i).size(); j++) {
                    System.out.print( (usuarios.get(relaciones.get(i).get(j)).getNombre()) + " ");
                }
            }
            System.out.println("");
        }
    }
}

class Usuario {
    private int id;
    private String nombre;

    Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
 