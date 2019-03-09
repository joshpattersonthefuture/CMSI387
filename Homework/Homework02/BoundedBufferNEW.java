//Authors: Joshua Patterson & Alex Richardson
//Date: March 8, 2019
//This file includes the old and improved version of Bounded Buffer
//HW #3 & 4
public class BoundedBufferNEW {
    private int SIZE = 3;
    private Object[] buffer = new Object[SIZE]; // arbitrary size
    private int numOccupied = 0;
    private int firstOccupied = 0;


/*~~~~~~~~~~~~~~~INSERTER*/
public class Inserter extends Thread {
  public synchronized void insert(Object o) throws InterruptedException {
        while (numOccupied == buffer.length) {
            wait();
        }
        buffer[(firstOccupied + numOccupied) % buffer.length] = o;
        numOccupied++;
            notifyAll();
  }


public void tester() {
         System.out.println("\nRunning inserter...\n");
         int n = 5;
         try {
             insert(n);
         } catch (InterruptedException ie) {
             System.out.println("Inserter finished....");
         }
     }
 }


/*~~~~~~~~~~~~~~~RETRIEVER*/
public class Retriever extends Thread {
 public synchronized Object retrieve() throws InterruptedException {
      while (numOccupied == 0)
            wait();
        Object retrieve = buffer[firstOccupied];
        buffer[firstOccupied] = null;
        firstOccupied = (firstOccupied + 1) % buffer.length;
        numOccupied--;
        if (numOccupied == SIZE) {
            notifyAll();
        }
        Thread.sleep(400);

        return retrieve;
    }

public void tester() {
        System.out.println("\nRunning retriever....\n");
        try {
           System.out.println( "Consumer has launched" );
           while ( numOccupied >= 0 ) {
               retrieve();
           }
             } catch (InterruptedException ie) {
                 System.out.println("Retriever finished...");
         }
         System.out.println("End");
       }
}

public static void main (String args[]) {
   Retriever r = new BoundedBufferNEW().new Retriever();
   Inserter i = new BoundedBufferNEW().new Inserter();
   r.start();
   i.start();
  }
}
