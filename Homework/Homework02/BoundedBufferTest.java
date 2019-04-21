//Joshua Patterson & Alex Richardson
// #3 & 4
public class BoundedBufferTest extends BoundedBuffer {
   /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
   public static void main ( String [] args ) throws Exception {
      BoundedBuffer bufferOne = new BoundedBuffer();
      NewBoundedBuffer bufferTwo = new NewBoundedBuffer();
      try{
        bufferOne.insert("hello world");
        bufferTwo.insert("goodbye world");
        System.out.println("Inserted");

        Object o = new Object();
        bufferOne.insert(o);
        bufferOne.retrieve();
        System.out.println("Retrieved");
      } catch (Exception e) {
        System.out.println(e);
        }
   }     
}
