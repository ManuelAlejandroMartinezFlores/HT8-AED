/**
 * @author Lourdes Saavedra
 * @author Manuel Martinez
 * 
 * Archivos
 * Lee el archivos txt.
 * 
 */

import java.util.PriorityQueue;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Archivos {
    
    /**
     * Lee el archivo txt y llena un PriorityQueue
     * @param path del archivo
     * @return priority queue
     * @throws IOException
     */
    public static PriorityQueue<Paciente> leer(String path) throws IOException{
        PriorityQueue<Paciente> pq = new PriorityQueue<Paciente>();
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
