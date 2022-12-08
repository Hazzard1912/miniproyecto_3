package actores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * GestionMedicos contiene solo un atributo de tipo Map, en el cual se van a
 * almacenar y a manejar los objetos de tipo Medico.
 *
 * @author Jhonnier Hernandez
 */
public class GestionMedicos implements IGestionDatos {

    private Map<Integer, Medico> listaMedicos;

    /**
     * Se inicializa el atributo listaMedicos como un HashMap.
     */
    public GestionMedicos() {

        listaMedicos = new HashMap<>();
    }

    /**
     * Crea la ventana donde se obtienen los datos para crear un Medico y lo
     * agrega a listaMedicos.
     */
    @Override
    public void agregar() {

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del medico a agregar");
        String dni = JOptionPane.showInputDialog("ingrese el dni del medico a agregar");
        int intDni = Integer.parseInt(dni);
        int especialista = JOptionPane.showConfirmDialog(null, "Es un especialista?");
        if (especialista == 0) {
            String especialidad = JOptionPane.showInputDialog("que especialidad tiene el medico?");
            Especialista medicoEspecialista = new Especialista(nombre, intDni, especialidad);
            listaMedicos.put(medicoEspecialista.getIdMedico(), medicoEspecialista);
        } else {
            Medico medico = new Medico(nombre, intDni);
            listaMedicos.put(medico.getIdMedico(), medico);
        }

    }

    /**
     * Actualiza los valores para nombreMedico del medico con el id que se haya
     * suministrado.
     */
    @Override
    public void actualizar() {

        String id = JOptionPane.showInputDialog("ingrese el id del medico a actualizar");
        int intId = Integer.parseInt(id);
        if (listaMedicos.containsKey(intId)) {
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
    public String listar() {
        
        String cadena = "---------- Medicos ----------\n";
        for (int clave : listaMedicos.keySet()) {
            var medico = listaMedicos.get(clave);
            cadena += medico + "\n";
        }
        return cadena;
    }

    /**
     * Cambia el estado del atributo estado del medico a false, y lo elimina de
     * listaMedicos, con lo cual se entiende que el medico esta inactivo.
     */
    @Override
    public void eliminar() {

        String id = JOptionPane.showInputDialog("ingrese el id del medico a eliminar");
        int intId = Integer.parseInt(id);

        if (listaMedicos.containsKey(intId)) {
            (listaMedicos.get(intId)).setEstado(false);
            listaMedicos.remove(intId);
            JOptionPane.showMessageDialog(null, "medico eliminido con exito del registro de medicos");
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en la lista de medicos o el id ingresado es incorrecto");
        }
    }

    /**
     * Genera el archivo csv con los datos basicos de los medicos, separados por
     * punto y coma (;) para la persistencia de los datos. el formato del
     * archivo es: nombre - dni - id - estado
     */
    @Override
    public void generarCSV() {

        String archivoCsv = "";
        for (int clave : listaMedicos.keySet()) {
            var medico = listaMedicos.get(clave);
            if (medico instanceof Especialista) {
                archivoCsv += medico.getNombre() + ";" + medico.getDni() + ";" + medico.getIdMedico() + ";" + medico.isEstado() + ";" + ((Especialista) medico).getEspecialidad() + ";" + "\n";
            } else {
                archivoCsv += medico.getNombre() + ";" + medico.getDni() + ";" + medico.getIdMedico() + ";" + medico.isEstado() + ";" + "\n";
            }
        }
        try {
            /**
             * Metodo para la persistencia de datos en forma de archivo binario:
             */
            FileOutputStream os = new FileOutputStream(new File("src/persistencia/medicos_csv.txt"));
            System.out.println("Comenzando a copiar...");
            os.write(archivoCsv.getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionMedicos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * El metodo tiene como funcion restaurar los datos llenando el atributo
     * listaMedicos con los datos almacenados en medicos_csv.txt
     */
    @Override
    public void restaurarDatos() {

        File archivo = new File("src/persistencia/medicos_csv.txt");
        StringTokenizer st;
        String cadenaDatos = "";
        try {
            FileReader fr = new FileReader(archivo);
            try ( BufferedReader br = new BufferedReader(fr)) {
                
                String cadena;
                while ((cadena = br.readLine()) != null) {
                    
                    cadenaDatos += cadena;
                    st = new StringTokenizer(cadena, ";");
                    if (st.countTokens() % 5 == 0 && st.countTokens() != 0) {
                        String nombre = st.nextToken();
                        int dni = Integer.parseInt(st.nextToken());
                        int id = Integer.parseInt(st.nextToken());
                        boolean estado = Boolean.parseBoolean(st.nextToken());
                        String especialidad = st.nextToken();
                        System.out.println("Creando y cargando especialista...");
                        Especialista especialista = new Especialista(nombre, dni, especialidad);
                        especialista.setIdMedico(id);
                        especialista.setEstado(estado);
                        listaMedicos.put(especialista.getIdMedico(), especialista);
                        System.out.println("especialista cargado con exito!");
                        
                    } else if (st.countTokens() % 4 == 0 && st.countTokens() != 0) {
                        String nombre = st.nextToken();
                        int dni = Integer.parseInt(st.nextToken());
                        int id = Integer.parseInt(st.nextToken());
                        boolean estado = Boolean.parseBoolean(st.nextToken());
                        System.out.println("Creando y cargando medico...");
                        Medico medico = new Medico(nombre, dni);
                        medico.setIdMedico(id);
                        medico.setEstado(estado);
                        listaMedicos.put(medico.getIdMedico(), medico);
                        System.out.println("medico cargado con exito!");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("Los datos contenidos en medicos_csv son: \n" + cadenaDatos);
            System.out.println("la lista de medicos resultante es: " + listaMedicos);
        }
    }
    
    /**
     * Retorna el medico contenido en listaMedicos, en la llave idMedico.
     * @param idMedico es la llave en la cual esta almacenado el medico que se 
     * desea acceder.
     * @return el medico contenido en listaMedicos.get(idMedico)
     */
    public Medico getMedico(int idMedico){
        return listaMedicos.get(idMedico);
    }
}
