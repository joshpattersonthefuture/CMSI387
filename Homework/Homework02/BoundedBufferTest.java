public class BoundedBufferTest {
    BoundedBuffer buff;

    public void test_full_buffer() throws Exception {
        buff = new BoundedBuffer();
        Thread t1 = new Thread();
        buff.insert(t1);
        buff.print();
        Thread t2 = new Thread();
        buff.insert(t2);
        buff.print();
        Thread t3 = new Thread();
        buff.insert(t3);
        buff.print();
        Thread t4 = new Thread();
        buff.insert(t4);
        buff.print();
    }


    public static void main(String[] args) {
        BoundedBufferTest test = new BoundedBufferTest();
        test.test_full_buffer();
    }
}