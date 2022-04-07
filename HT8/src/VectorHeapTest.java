import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorHeapTest {
    
    @Test
    void testInsert(){
        PriorityQueue<Integer> pq = new VectorHeap<Integer>();
        pq.add(3);
        pq.add(5);
        pq.add(1);
        pq.add(4);
        pq.add(2);

        assertEquals(1, pq.remove());
    }
}
