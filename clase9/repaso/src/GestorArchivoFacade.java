import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestorArchivoFacade {
    public String leerArchivo(String nombre ) throws IOException {
        
        FileReader fileReader = new FileReader(nombre);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea;
        String resultado = "";
        while((linea=bufferedReader.readLine()) != null) {
            resultado = resultado + linea;
        }
        bufferedReader.close();
        fileReader.close();
        return resultado;
    }   
}
