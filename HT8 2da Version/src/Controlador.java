import java.util.PriorityQueue;

public class Controlador {
    
    public static void main(String[] args){
        Vista vista = new Vista();

        PriorityQueue<Paciente> pq;
        while (true){
            try{
                pq = Archivos.leer(vista.getPath());
                break;
            } catch (Exception e){
                vista.mostrarMsg("\nError al leer el archivo\n");
            }
        }

        while (!pq.isEmpty()){
            vista.getPaciente();
            vista.mostrarMsg(pq.remove().toString() + "\n");
        }

        vista.mostrarMsg("Cerrando...");
    }

}
