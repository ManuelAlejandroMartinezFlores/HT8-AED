/**
 * @author Lourdes Saavedra
 * @author Manuel Martinez
 * 
 * Paciente
 * Contiene la ficha del paciente.
 * 
 */

public class Paciente implements Comparable<Paciente> {
    
    String nombre;
    String sintoma;
    String prioridad;

    /**
     * Constructor
     * @param nombre_ del paciente
     * @param sintoma_
     * @param prioridad_
     */
    Paciente(String nombre_, String sintoma_, String prioridad_){
        nombre = nombre_;
        sintoma = sintoma_;
        prioridad = prioridad_;
    }

    /**
     * Indica prioridad del paciente
     * @return prioridad
     */
    public String getPrioridad(){
        return prioridad;
    }

    /**
     * Compara pacientes
     */
    @Override
    public int compareTo(Paciente o) {
        return prioridad.compareTo(o.getPrioridad());
    }

    /**
     * Genera texto con ficha del paciente
     */
    @Override
    public String toString(){
        return nombre + " - " + sintoma + " - " + prioridad;
    }
}
