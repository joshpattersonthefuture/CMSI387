//Joshua Patterson & Alex Richardson
// #3 & 4

//define first BoundedBuffer
public class BoundedBuffer {
    private int SIZE = 3;
    private Object[] buffer = new Object[SIZE]; // arbitrary size
    private int numOccupied = 0;
    private int firstOccupied = 0;


//insert and retrieve for first BoundedBuffer
    public synchronized void insert(Object o) throws InterruptedException {
        while (numOccupied == buffer.length)
            wait();
        buffer[(firstOccupied + numOccupied) % buffer.length] = o;
        numOccupied++;
            notifyAll();
    }

    public synchronized Object retrieve() throws InterruptedException {
        while (numOccupied == 0)
            wait();
        Object retrieved = buffer[firstOccupied];
        buffer[firstOccupied] = null; // may help garbage collector
        firstOccupied = (firstOccupied + 1) % buffer.length;
        numOccupied--;
            notifyAll();
              return retrieved;
   }
}
//insert and retrieve for second BoundedBuffer
class NewBoundedBuffer  {
    private int SIZE = 3;
    private Object[] buffer = new Object[SIZE];
    public int numOccupied = 0;
    public int firstOccupied = 0;

//define new BoundedBuffer
    public NewBoundedBuffer() {
        this.buffer = new Object[SIZE];
        this.numOccupied = 0;
        this.firstOccupied = 0;
    }

  public synchronized void insert(Object o) throws InterruptedException {
      while (numOccupied == buffer.length)
          wait();
      buffer[(firstOccupied + numOccupied) % buffer.length] = o;
      numOccupied++;
       if (numOccupied == 0) {
          notifyAll();
        }     
  }

  public synchronized Object retrieve() throws InterruptedException {
      while (numOccupied == 0)
          wait();
      Object retrieved = buffer[firstOccupied];
      buffer[firstOccupied] = null; // may help garbage collector
      firstOccupied = (firstOccupied + 1) % buffer.length;
      numOccupied--;
      if (numOccupied == SIZE) {
       notifyAll();
      }
   return retrieved;
 }
}
