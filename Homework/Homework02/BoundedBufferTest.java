public class BoundedBufferTest {
    BoundedBuffer buff;

    public void test_full_buffer() {
        buff = new BoundedBuffer();
        
        Thread t1 = new Thread();
        try {
            buff.insert(t1);
        } catch (Exception e) {
            System.out.println("Cannot insert thread to buffer");
        }
        buff.print();

        Thread t2 = new Thread();
        try {
            buff.insert(t2);
        } catch (Exception e) {
            System.out.println("Cannot insert thread to buffer");
        }
        buff.print();

        Thread t3 = new Thread();
        try {
            buff.insert(t3);
        } catch (Exception e) {
            System.out.println("Cannot insert thread to buffer");
        }
        buff.print();

        Thread t4 = new Thread();
        try {
            buff.insert(t4);
        } catch (Exception e) {
            System.out.println("Cannot insert thread to buffer");
        }
        buff.print();
    }


    public static void main(String[] args) {
        BoundedBufferTest test = new BoundedBufferTest();
        test.test_full_buffer();
    }
}