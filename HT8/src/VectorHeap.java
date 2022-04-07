import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {


    Vector<E> data;

    VectorHeap(){
        data = new Vector<E>();
        data.add(null);
    }

    @Override
    public E getFirst() {
        return data.firstElement();
    }

    @Override
    public E remove() {
        E first = data.remove(1);
        data.set(1, data.get(size()-1));
        minHeapify(1);
        return first;
    }

    @Override
    public void add(E value) {
        data.add(value);
        int current = size();
        while (data.get(current).compareTo(data.get(parent(current))) < 0){
            swap(current, parent(current));
            current = parent(current);
        }
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size() == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return data.size() - 1;
    }

    @Override
    public void clear() {
        data.removeAllElements();
    }


    private void swap(int i1, int i2){
        E tmp = data.get(i1);
        data.set(i1, data.get(i2));
        data.set(i2, tmp);
    }

    private int parent(int pos) { return pos / 2; }
    
    public String toString(){
        String txt = "";
        for (int i = 1; i <= size() / 2; i++) {
 
            // Printing the parent and both childrens
            txt += " PARENT: " + data.get(i);
            txt += " LEFT CHILD: " + data.get(2 * i);
            txt += " RIGHT CHILD:" + data.get(2 * i + 1);
 
            // By here new line is required
            txt += "\n";
        }
        return txt;
    }

    private void minHeapify(int pos){
 
        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (data.get(pos).compareTo(data.get(leftChild(pos))) > 0
                || data.get(pos).compareTo(data.get(rightChild(pos))) > 0) {
 
                // Swap with the left child and heapify
                // the left child
                if (data.get(leftChild(pos)).compareTo(data.get(rightChild(pos))) < 0) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
 
                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    private int leftChild(int pos) { return (2 * pos); }
 
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos)
    {
 
        if (pos > (size() / 2) && pos <= size()) {
            return true;
        }
 
        return false;
    }
    
}
