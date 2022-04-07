import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorHeapTest {
    
    @Test
    void testInsertRemove(){
        PriorityQueue<Integer> pq = new VectorHeap<Integer>();
        pq.add(3);
        pq.add(5);
        pq.add(1);
        pq.add(4);
        pq.add(2);

        assertEquals(1, pq.remove());
        assertEquals(2, pq.remove());
        assertEquals(3, pq.remove());
        assertEquals(4, pq.remove());
        assertEquals(5, pq.remove());
    }

    @Test
    void testPaciente(){
        try {
            PriorityQueue<Paciente> pq = Archivos.leer("/Users/manuelmartinezflores/Documents/GitHub/HT8-AED/HT8/src/pacientes.txt");
            assertEquals("A", pq.remove().getPrioridad());
            assertEquals("A", pq.remove().getPrioridad());
            assertEquals("B", pq.remove().getPrioridad());
            assertEquals("B", pq.remove().getPrioridad());
            assertEquals("C", pq.remove().getPrioridad());
            assertEquals("C", pq.remove().getPrioridad());
            assertEquals("E", pq.remove().getPrioridad());
        } catch (Exception e){
            System.out.println(e);
            fail();
        }

        
    }

}
