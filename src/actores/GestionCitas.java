package actores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.VentanaHora;

/**
 * Clase que se encarga de gestionar las citas medicas y almacenarlas en un 
 * HashMap
 * @author Jhonnier Hernandez
 */
public class GestionCitas {
    
    private Map<Integer, CitaMedica> citasMedicas;
    
    /**
     * Construye el objeto e inicializa el atributo citasMedicas como un HashMap
     */
    public GestionCitas() {
        citasMedicas = new HashMap<>();
    }
    
    /**
     * Crea y agrega una cita al atributo citasMedicas. como crear una cita 
     * requiere de los parametros Afiliado, Servicio, Medico, Consultorio y 
     * Calendar, esto se obtienen en la ejecucion del metodo.
     * @param gestionAfiliados permite acceder al afiliado
     * @param gestionServicios permite acceder al servicio
     * @param gestionMedicos permite acceder al medico
     * @param gestionConsultorios permite acceder al consultorio
     */
    public void agregar(GestionAfiliados gestionAfiliados, GestionServiciosMedicos gestionServicios,
            GestionMedicos gestionMedicos, GestionConsultorios gestionConsultorios) {
        
        String idAfiliado = JOptionPane.showInputDialog("Ingrese el id del afiliado");
        String servicio = JOptionPane.showInputDialog("Ingrese el numero del servicio medico que precisa el afiliado");
        String idMedico = JOptionPane.showInputDialog("Ingrese el id del medico que atendera la cita");
        String consultorio = JOptionPane.showInputDialog("Ingrese el numero del consultorio donde tendra lugar la cita");
        Calendar cal = VentanaHora.cal;
        if(citasMedicas.containsKey(Integer.valueOf(idAfiliado))){
            JOptionPane.showMessageDialog(null, "El afiliado ya tiene una cita registrada");
        } else {
            System.out.println("Creando cita...");
            CitaMedica cita = new CitaMedica(gestionAfiliados.getAfiliado(Integer.parseInt(idAfiliado)), 
                gestionServicios.getServicio(Integer.parseInt(servicio)), gestionMedicos.getMedico(Integer.parseInt(idMedico)),
                gestionConsultorios.getConsultorio(Integer.parseInt(consultorio)-1), cal);
            System.out.println("cita generada con exito");
            System.out.println("cita = " + cita);
            citasMedicas.put((gestionAfiliados.getAfiliado(Integer.parseInt(idAfiliado))).getIdAfiliado(), cita);
        }
    }
    
    /**
     * Permite actualizar la fecha de la cita.
     */
    public void actualizar() {
        
        //Crear el funcionamiento de este metodo...
        
    }

    public void eliminar() {
        
        String cita = JOptionPane.showInputDialog("ingrese el id del afiliado para eliminar su cita");
        int intCita = Integer.parseInt(cita);
        
        if(citasMedicas.containsKey(intCita)){
            citasMedicas.remove(intCita);
            JOptionPane.showMessageDialog(null, "cita eliminida con exito del registro de citas");
        } else {
            JOptionPane.showMessageDialog(null, "La cita no se encuentra registrada");
        }
    }
    
    public String listar() {
        String cadena = "---------- Citas ----------\n";
        for(int clave : citasMedicas.keySet()){
            var cita = citasMedicas.get(clave);
            cadena += cita + "\n";
        }
        return cadena;
    }

    public void generarCSV() {
        
        CitaMedica cita;
        String archivoCsv = "";
        for (int clave:citasMedicas.keySet()) {
            cita = citasMedicas.get(clave);
            archivoCsv += (cita.getAfiliado()).getNombre() + ";" + cita.getServicioMedico() + ";" + (cita.getMedico()).getNombre() 
                    + ";" + (cita.getConsultorio()).getNombre()+ ";" + "\n";
        }
        try {
            /**
             * Metodo para la persistencia de datos en forma de archivo binario:
             */
            FileOutputStream os = new FileOutputStream(new File("src/persistencia/citas_csv.txt"));
            System.out.println("Comenzando a copiar...");
            os.write(archivoCsv.getBytes());
            System.out.println("Copiado con exito!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void restaurarDatos() {
        
    }
}
