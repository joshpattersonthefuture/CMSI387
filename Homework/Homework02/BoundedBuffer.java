public class BoundedBuffer {
    private int SIZE = 3;
    private Object[] buffer = new Object[SIZE]; // arbitrary size
    private int numOccupied = 0;
    private int firstOccupied = 0;

    /*
     * invariant: 0 <= numOccupied <= buffer.length 0 <= firstOccupied <
     * buffer.length buffer[(firstOccupied + i) % buffer.length] contains the
     * (i+1)th oldest entry, for all i such that 0 <= i < numOccupied
     */
public class Inserter extends Thread {
    public synchronized void insert(Object o) throws InterruptedException {
        while (numOccupied == buffer.length)
            // wait for space
            wait();
        buffer[(firstOccupied + numOccupied) % buffer.length] = o;
        numOccupied++;
        if (numOccupied == 0) {
            notifyAll();
        }
    }
}

public class Retriever extends Thread {
    public synchronized Object retrieve() throws InterruptedException {
        while (numOccupied == 0)
            // wait for data
            wait();
        Object retrieved = buffer[firstOccupied];
        buffer[firstOccupied] = null; // may help garbage collector
        firstOccupied = (firstOccupied + 1) % buffer.length;
        numOccupied--;
        // in case any inserts are waiting for space, wake them
        if (numOccupied == SIZE) {
            notifyAll();
        }
        return retrieved;
    }
}

    public void print() {
        System.out.print("Buffer Contains: ");
        for (Object a : buffer) {
            System.out.print(a + " ");
        }
        System.out.print("Num Occupied: " + numOccupied);
        System.out.println("First Occupied: " + firstOccupied);
    }


public static void main (String args[]) {
   Retriever r = new BoundedBuffer().new Retriever();
   Inserter i = new BoundedBuffer().new Inserter();
   r.start();
   i.start();
  }
}
