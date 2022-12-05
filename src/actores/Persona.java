package actores;

/**
 * La cualidad que comparten tanto medicos como afiliados
 * @author PC
 */
public class Persona {
    private String nombre;
    private final int dni;
    
    /**
     * Crea una persona y setea los atributos nombrey dni.
     * @param nombre es el valor a asignar al atributo nombre
     * @param dni es el valor a asignar al atributo dni
     */
    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    /**
     * Retorna el nombre de la persona.
     * @return el valor de nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Asigna el valor del parametro al atributo nombre
     * @param nombre el valor a asignarle al atributo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Retorna el dni de la persona
     * @return el valor de dni
     */
    public int getDni() {
        return dni;
    }
}
