package actores;

/**
 * Un objeto de clase Medico tiene los atributos para almacenar el nombre,
 * el dni, el id y el estado, el cual es activo para true e inactivo para false.
 * @author Jhonnier Hernandez
 */
public class Medico extends Persona{
    private int idMedico;
    private boolean estado;
    public static int cantidadMedicos;
    
    /**
     * Crea un medico que extiende de persona, ademas de setear el estado en 
     * true y le asigna el id de medico segun la cantidad de medicos que hay.
     * @param nombreMedico es el valor a asignar al atributo nombre de Persona
     * @param dniMedico es el valor a asignar al atributo dni de Persona
     */
    public Medico(String nombreMedico, int dniMedico){
        super(nombreMedico, dniMedico);
        estado = true;
        cantidadMedicos++;
        idMedico = cantidadMedicos;
    }
    
    /**
     * Retorna el id del medico
     * @return el valor de idMedico
     */
    public int getIdMedico() {
        return idMedico;
    }
    
    /**
     * Asigna el valor del parametro al atributo idMedico
     * @param idMedico el valor a asignarle al atributo idMedico
     */
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
    
    /**
     * Retorna el estado del medico, false para inactivo, true para activo
     * @return el valor de estado
     */
    public boolean isEstado() {
        return estado;
    }
    
    /**
     * Asigna el valor del parametro estado al atributo estado
     * @param estado el valor a asignarle al atributo estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    /**
     * Retorna la cantidad de Medicos que hay
     * @return el valor de cantidadMedicos
     */
    public static int getCantidadMedicos() {
        return cantidadMedicos;
    }
    
    /**
     * Retorna los datos de interes del medico, su nombre, dni y id.
     * @return un String con los datos del medico.
     */
    @Override
    public String toString() {
        return "Medico{" + "nombre=" + this.getNombre() + ", dni=" + this.getDni() + ", idMedico=" + idMedico + ", estado=" + estado + '}';
    }
}
