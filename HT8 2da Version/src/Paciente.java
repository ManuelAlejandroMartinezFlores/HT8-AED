public class Paciente implements Comparable<Paciente> {
    
    String nombre;
    String sintoma;
    String prioridad;

    Paciente(String nombre_, String sintoma_, String prioridad_){
        nombre = nombre_;
        sintoma = sintoma_;
        prioridad = prioridad_;
    }

    public String getPrioridad(){
        return prioridad;
    }

    @Override
    public int compareTo(Paciente o) {
        return prioridad.compareTo(o.getPrioridad());
    }

    @Override
    public String toString(){
        return nombre + " - " + sintoma + " - " + prioridad;
    }
}
