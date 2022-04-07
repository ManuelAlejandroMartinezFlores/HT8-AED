import java.util.Vector;

<<<<<<< Updated upstream
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{

	protected Vector<E> data; // the data, kept in heap order

	public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}

	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}
	protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i-1)/2;
	}

	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2*i+1;
	}

	protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2*i+1) + 1;
	}

	protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
		(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

	public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size()-1);
	}

	protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

	public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
    }

    @Override
    public E getFirst() 
     // pre: !isEmpty()
    // post: returns the minimum value in the priority queue
    {    
        return data.get(0);
=======
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
        
>>>>>>> Stashed changes
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
<<<<<<< Updated upstream
        return false;
=======
        return size() == 0;
>>>>>>> Stashed changes
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
<<<<<<< Updated upstream
        return 0;
=======
        return data.size() - 1;
>>>>>>> Stashed changes
    }

    @Override
    public void clear() {
<<<<<<< Updated upstream
        // TODO Auto-generated method stub
        
    }
}
=======
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
>>>>>>> Stashed changes
