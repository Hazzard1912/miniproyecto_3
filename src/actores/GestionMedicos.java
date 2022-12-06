package actores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GestionMedicos contiene solo un atributo de tipo Map, en el cual se van a almacenar
 y a manejar los objetos de tipo Medico.
 * @author Jhonnier Hernandez
 */

public class GestionMedicos implements IGestionDatos{
    private Map <Integer, Medico> listaMedicos;
    
    /**
     * Se inicializa el atributo listaMedicos como un HashMap.
     */
    public GestionMedicos(){
        listaMedicos = new HashMap<>();
    }
    
    
    /**
     * Agrega medico a listaAfiliados y lo relaciona con su id en el Map.
     * @param medico es el objeto a ser agregado.
     */
    @Override
    public void agregar(){
//        Crea la ventana donde captura los datos para crear un medico a agregar
//        listaMedicos.put(medico.getIdMedico(), medico);
    }
    
    /**
     * Actualiza los valores para nombreMedico y dniMedico del parametro.
     * @param medico el objeto a ser actualizado.
     */
    @Override
    public void actualizar(){
//        Crea la ventana donde solicita el id y los datos a actualizar
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Digite el nombre del medico: ");
//        medico.setNombre(sc.nextLine());
//        System.out.println("digite el dni del medico: ");
//        medico.setDni(sc.nextInt());    
    }
    
    /**
     * Imprime en consola todo el Map listaMedicos, con lo cual lista todos
 los GestionMedicos contenidos.
     */
    @Override
    public String listar(){
        String cadena = "";
        for(int clave : listaMedicos.keySet()){
            Medico medico = listaMedicos.get(clave);
            cadena += medico + "\n";
        }
        return cadena;
    }
    
    /**
     * Cambia el estado del parametro a false, y lo elimina de listaMedicos,
     * con lo cual se entiende que el afiliado esta inactivo.
     * @param medico el objeto a ser eliminado.
     */
    @Override
    public void eliminar(){
//        Crea la ventana donde solicita el id del medico a eliminar
//        listaMedicos.remove(medico.getIdMedico());
//        medico.setEstado(false);
    }
    
    @Override
    public void generarCSV(){
        Medico medico;
        String archivoCsv = "";
        for (int clave:listaMedicos.keySet()) {
            medico = listaMedicos.get(clave);
            archivoCsv += medico.getNombre() + ";" + medico.getDni() + ";" + medico.getIdMedico()+ ";" + medico.isEstado() + ";" + "\n";
        }
        try {
            /**
             * Metodo para la persistencia de datos en forma de archivo binario:
             */
            FileOutputStream os = new FileOutputStream(new File("src/persistencia/medicos_csv.txt"));
            System.out.println("Comenzando a copiar...");
            int aux;
            os.write(archivoCsv.getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionMedicos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}