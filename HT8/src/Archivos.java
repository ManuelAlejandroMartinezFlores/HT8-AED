import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Archivos{

    public static PriorityQueue<Paciente> leer(String path) throws IOException{
        PriorityQueue<Paciente> pq = new VectorHeap<Paciente>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String row;
        while ((row = reader.readLine()) != null){
        	String[] data = row.split(", ");
            pq.add(new Paciente(data[0], data[1], data[2]));
        }
        reader.close();
        return pq;
    }
}