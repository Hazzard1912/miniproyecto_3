package actores;

/**
 * Clase que modela un consultorio mediante los atributos de nombre y 
 * disponibilidad
 * @author Jhonnier Hernandez
 */
public class Consultorio {
    private String numero;
    private boolean disponibilidad;
    
    /**
     * Crea un consultorio y le asigna el nombre y la disponibilidad
     * @param nombre es el valor a asignar al atributo nombre
     * @param disponibilidad es el valor a asignar al atributo disponibilidad
     */
    public Consultorio(String nombre, boolean disponibilidad) {
        this.numero = nombre;
        this.disponibilidad = disponibilidad;
    }
    
    /**
     * Retorna el nombre del consultorio
     * @return el valor de nombre
     */
    public String getNumero() {
        return numero;
    }
    
    /**
     * Actualiza el nombre del consultorio
     * @param nombre es el valor a asignar al atributo nombre
     */
    public void setNombre(String nombre) {
        this.numero = nombre;
    }
    
    /**
     * Retorna la disponibilidad del consultorio
     * @return el valor de disponibilidad
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    
    /**
     * Actualiza la disponibilidad del consultorio
     * @param disponibilidad es el valor a asignar al atributo disponibilidad
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Consultorio{" + "numero=" + numero + ", disponibilidad=" + disponibilidad + '}';
    }
    
}
