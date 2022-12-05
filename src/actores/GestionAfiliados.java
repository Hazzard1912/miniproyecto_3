package actores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GestionAfiliados contiene solo un atributo de tipo Map, en el cual se van a almacenar
 y a manejar los objetos de tipo Afiliado.
 * @author Jhonnier Hernandez
 */

public class GestionAfiliados implements IGestionDatos{
    private Map <Integer, Afiliado> listaAfiliados;
    
    /**
     * Se inicializa el atributo listaAfiliados como un HashMap.
     */
    public GestionAfiliados(){
        listaAfiliados = new HashMap<>();
    }
    
    
    /**
     * Agrega afiliado a listaAfiliados y lo relaciona con su id en el Map.
     * @param afiliado es el objeto a ser agregado.
     */
    @Override
    public void agregar(){
        //Crea la ventana donde se obtienen los datos para crear un Afiliado.
        //listaAfiliados.put(afiliado.getIdAfiliado(), afiliado);
    }
    
    /**
     * Actualiza los valores para nombreAfiliado y dniAfiliado del parametro.
     * @param afiliado el objeto a ser actualizado.
     */
    @Override
    public void actualizar(){
//        Crea la ventana que solicita el id del afiliado a actualizar.
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Digite el nombre del afiliado: ");
//        afiliado.setNombre(sc.nextLine());
//        System.out.println("digite el dni del afiliado: ");
//        afiliado.setDni(sc.nextInt());    
    }
    
    /**
     * Imprime en consola todo el Map listaAfiliados, con lo cual lista todos
     * los afiliados contenidos.
     */
    @Override
    public void listar(){
        for(int clave : listaAfiliados.keySet()){
            Afiliado afiliado = listaAfiliados.get(clave);
            System.out.println(afiliado);
        }
    }
    
    /**
     * Cambia el estado del parametro a false, y lo elimina de listaAfiliados,
     * con lo cual se entiende que el afiliado esta inactivo.
     * @param afiliado el objeto a ser eliminado.
     */
    @Override
    public void eliminar(){
//        Crea la ventana que solicita el id del afiliado a eliminar
//        listaAfiliados.remove(afiliado.getIdAfiliado());
//        afiliado.setEstado(false);
    }
    
    @Override
    public void  generarCSV(){
        Afiliado afiliado;
        String archivoCsv = "";
        for (int clave:listaAfiliados.keySet()) {
            afiliado = listaAfiliados.get(clave);
            archivoCsv += afiliado.getNombre() + ";" + afiliado.getDni() + ";" + afiliado.getIdAfiliado() + ";" + afiliado.isEstado() + ";" + "\n";
        }
        try {
            /**
             * Metodo para la persistencia de datos en forma de archivo binario:
             */
            FileOutputStream os = new FileOutputStream(new File("src/persistencia/afiliados_csv.txt"));
            System.out.println("Comenzando a copiar...");
            int aux;
            os.write(archivoCsv.getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
