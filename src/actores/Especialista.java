package actores;

/**
 * 
 * Clase que modela un especialista medico con un unico atributo, su especialidad.
 * @author Jhonnier Hernandez
 */
public class Especialista extends Medico {
    
    private String especialidad;
    
    /**
     * Crea el especialista que extiende de medico, asignando el valor del 
     * parametro especialidad al atributo especialidad.
     * @param nombreMedico es el valor que se asigna a nombreMedico en el constructor de super
     * @param dniMedico es el valor que se asigna a dniMedico en el constructor de super
     * @param especialidad es el valor que se asigna al atributo especialidad
     */
    public Especialista(String nombreMedico, int dniMedico, String especialidad) {
        super(nombreMedico, dniMedico);
        this.especialidad = especialidad;
    }
    
    /**
     * Retorna la especialidad del especialista
     * @return el valor de especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }
    
    /**
     * Asigna el valor del parametro al atributo especialidad
     * @param especialidad es el valor que se asigna al atributo especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Especialista{" + "nombre=" + getNombre() + ", dni=" + getDni() + ", idMedico=" + getIdMedico() + ", estado=" + isEstado() + ", especialidad=" + especialidad + '}';
    }
    
    
}
