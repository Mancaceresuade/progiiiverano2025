import java.util.Scanner;

public class Actividad3 {
    // Falta excepcion por division por 0
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero1 = pedirUnNumero(scanner);
        int numero2 = pedirUnNumero(scanner);
        int operacion = pedirUnNumero(scanner);
        int resultado = 0;
        switch (operacion) {
            case 1:
                resultado = numero1 + numero2;
                break;
            case 2:
                resultado = numero1 - numero2;
                break;
            case 3:
                resultado = numero1 * numero2;
                break;
            case 4:
                resultado = numero1 / numero2;
                break;        
            default:
                break;
        }
        System.out.println(resultado);
    }
    private static int pedirUnNumero(Scanner scanner) {
        System.out.println("Ingrese un numero");
        int numero = scanner.nextInt();
        return numero;
    }

}
