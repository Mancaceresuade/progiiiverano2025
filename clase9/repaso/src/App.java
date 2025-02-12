import java.io.IOException;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        
        GestorArchivoFacade gestorArchivoFacade = new GestorArchivoFacade();
        try {
            String datos = gestorArchivoFacade.leerArchivo("datos.json");
            System.out.println(datos);
            Gson gson = new Gson();
            EmpresaDto empresaDto = gson.fromJson(datos, EmpresaDto.class);
            System.out.println(empresaDto);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
