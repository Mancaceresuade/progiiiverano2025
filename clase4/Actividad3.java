package clase4;
import java.util.ArrayList;
import java.util.List;
 
class Cliente {
     int id;
     String nombre;
     int scoring;
 
     public Cliente(int id, String nombre, int scoring) {
         this.id = id;
         this.nombre = nombre;
         this.scoring = scoring;
     }
 }
 
 public class Actividad3 {
 
     public static class Resultado {
         Cliente mayor;
         Cliente segundoMayor;
 
         public Resultado(Cliente mayor, Cliente segundoMayor) {
             this.mayor = mayor;
             this.segundoMayor = segundoMayor;
         }
     }
 
     public static Resultado encontrarDosClientesMaximoScoring(List<Cliente> listaClientes, int inicio, int fin) {
         // Caso base: Si la lista tiene solo un elemento
         if (inicio == fin) {
             return new Resultado(listaClientes.get(inicio), null);
         }
 
         // Caso base: Si la lista tiene solo dos elementos
         if (fin - inicio == 1) {
             if (listaClientes.get(inicio).scoring > listaClientes.get(fin).scoring) {
                 return new Resultado(listaClientes.get(inicio), listaClientes.get(fin));
             } else {
                 return new Resultado(listaClientes.get(fin), listaClientes.get(inicio));
             }
         }
 
         // Dividir: Calcular el punto medio de la lista
         int medio = (inicio + fin) / 2;
 
         // Conquistar: Llamar recursivamente a la función para las dos mitades de la lista
         Resultado izquierda = encontrarDosClientesMaximoScoring(listaClientes, inicio, medio);
         Resultado derecha = encontrarDosClientesMaximoScoring(listaClientes, medio + 1, fin);
 
         // Combinar: Encontrar los dos mayores entre las dos mitades
         Cliente mayor, segundoMayor;
         if (izquierda.mayor.scoring > derecha.mayor.scoring) {
             mayor = izquierda.mayor;
             if (izquierda.segundoMayor == null || derecha.mayor.scoring > izquierda.segundoMayor.scoring) {
                 segundoMayor = derecha.mayor;
             } else {
                 segundoMayor = izquierda.segundoMayor;
             }
         } else {
             mayor = derecha.mayor;
             if (derecha.segundoMayor == null || izquierda.mayor.scoring > derecha.segundoMayor.scoring) {
                 segundoMayor = izquierda.mayor;
             } else {
                 segundoMayor = derecha.segundoMayor;
             }
         }
 
         return new Resultado(mayor, segundoMayor);
     }
 
     public static void main(String[] args) {
         // Ejemplo de uso
         List<Cliente> listaClientes = new ArrayList<>();
         listaClientes.add(new Cliente(1, "Cliente A", 85));
         listaClientes.add(new Cliente(2, "Cliente B", 92));
         /*
         listaClientes.add(new Cliente(3, "Cliente C", 78));
         listaClientes.add(new Cliente(4, "Cliente D", 95));
         listaClientes.add(new Cliente(5, "Cliente E", 88));
         listaClientes.add(new Cliente(6, "Cliente F", 70));
         listaClientes.add(new Cliente(7, "Cliente G", 99));
         listaClientes.add(new Cliente(8, "Cliente H", 65));
         listaClientes.add(new Cliente(9, "Cliente I", 80));
  */
         // Llamar a la función
         int inicio = 0;
         int fin = listaClientes.size() - 1;
         Resultado resultado = encontrarDosClientesMaximoScoring(listaClientes, inicio, fin);
 
         // Imprimir los resultados
         System.out.println("Los dos clientes con mayor scoring son:");
         System.out.println("Mayor: ID: " + resultado.mayor.id + ", Nombre: " + resultado.mayor.nombre + ", Scoring: " + resultado.mayor.scoring);
        if (resultado.segundoMayor != null) {
             System.out.println("Segundo mayor: ID: " + resultado.segundoMayor.id + ", Nombre: " + resultado.segundoMayor.nombre + ", Scoring: " + resultado.segundoMayor.scoring);
         } else {
             System.out.println("Segundo mayor: No hay");
         }
     }
 }