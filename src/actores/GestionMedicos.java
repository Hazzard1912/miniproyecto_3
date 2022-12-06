package actores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
     * Crea la ventana donde se obtienen los datos para crear un Medico y lo 
     * agrega a listaMedicos.
     */
    @Override
    public void agregar(){
        
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del medico a agregar");
        String dni = JOptionPane.showInputDialog("ingrese el dni del medico a agregar");
        int intDni = Integer.parseInt(dni);
        int especialista = JOptionPane.showConfirmDialog(null, "Es un especialista?");
        if(especialista == 0){
            String especialidad = JOptionPane.showInputDialog("que especialidad tiene el medico?");
            Especialista medicoEspecialista = new Especialista(nombre, intDni, especialidad);
            listaMedicos.put(intDni, medicoEspecialista);
        } else {
            Medico medico = new Medico(nombre, intDni);
            listaMedicos.put(medico.getIdMedico(), medico);
        }
        
    }
    
    /**
     * Actualiza los valores para nombreMedico del medico con el id que se
     * haya suministrado.
     */
    @Override
    public void actualizar(){
        
        String id = JOptionPane.showInputDialog("ingrese el id del medico a actualizar");
        int intId = Integer.parseInt(id);
        if(listaMedicos.containsKey(intId)){
            String nombre = JOptionPane.showInputDialog("ingrese el nuevo nombre del medico");
            (listaMedicos.get(intId)).setNombre(nombre);
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en la lista de medicos");
        }
    }
    
    /**
     * Retorna un String con todos los medicos contenidos en listMedicos
     * @return los datos de cada medico en el atributo listaMedicos
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
     * Cambia el estado del atributo estado del medico a false, y lo elimina 
     * de listaMedicos, con lo cual se entiende que el medico esta inactivo.
     */
    @Override
    public void eliminar(){

        String id = JOptionPane.showInputDialog("ingrese el id del medico a eliminar");
        int intId = Integer.parseInt(id);
        
        if(listaMedicos.containsKey(intId)){
            (listaMedicos.get(intId)).setEstado(false);
            listaMedicos.remove(intId);
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en la lista de medicos o el id ingresado es incorrecto");
        }
    }
    
    /**
     * Genera el archivo csv con los datos basicos de los medicos, separados
     * por punto y coma (;) para la persistencia de los datos. el formato del
     * archivo es: nombre - dni - id - estado
     */
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