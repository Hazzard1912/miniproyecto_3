package actores;

/**
 * Un objeto de clase Afiliado tiene los atributos para almacenar el nombre,
 * el dni, el id y el estado, el cual es activo para true e inactivo para false.
 * @author Jhonnier Hernandez
 */
public class Afiliado extends Persona{
    private int idAfiliado;
    private boolean estado;
    public static int cantidadAfiliados;
    
    /**
     * Crea un afiliado y setea los atributos nombreAfiliado y dniAfiliado, 
     * ademas de setear el estado en true y le asigna el id de afiliado segun
     * la cantidad de afiliados que hay.
     * @param nombreAfiliado es el valor a asignar al atributo nombreAfiliado
     * @param dniAfiliado es el valor a asignar al atributo dniAfiliado
     */
    public Afiliado(String nombreAfiliado, int dniAfiliado){
        super(nombreAfiliado, dniAfiliado);
        estado = true;
        cantidadAfiliados++;
        idAfiliado = cantidadAfiliados;
    }
    
    /**
     * Retorna el id del afiliado
     * @return el valor de idAfiliado
     */
    public int getIdAfiliado() {
        return idAfiliado;
    }
    
    /**
     * Asigna el valor del parametro al atributo idAfiliado
     * @param idAfiliado el valor a asignarle al atributo idAfiliado
     */
    public void setIdAfiliado(int idAfiliado) {
        this.idAfiliado = idAfiliado;
    }
    
    /**
     * Retorna el estado del afiliado, false para inactivo, true para activo
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
     * Retorna la cantidad de Afiliados que hay
     * @return el valor de cantidadAfiliados
     */
    public static int getCantidadAfiliados() {
        return cantidadAfiliados;
    }
    
    /**
     * Retorna los datos de interes del afiliado, su nombre, dni y id.
     * @return un String con los datos del afiliado.
     */
    @Override
    public String toString() {
        return "Afiliado{" + "nombre=" + this.getNombre() + ", dni=" + this.getDni() + ", idAfiliado=" + idAfiliado + ", estado=" + estado + '}';
    }
}
