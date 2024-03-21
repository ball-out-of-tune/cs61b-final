import static org.junit.Assert.*;
import org.junit.Test;
public class ArrayDequeTset {
    @Test
    public void addFunctionTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
//        arrayDeque.get();
//        arrayDeque.plusOne();
//        arrayDeque.get();
//        arrayDeque.setFirst(7);
//        arrayDeque.get();
//        arrayDeque.plusOne();
//        arrayDeque.get();
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(3);
        arrayDeque.addLast(9);
        int a = arrayDeque.get(0);
        int b = arrayDeque.get(2);
//        System.out.println(arrayDeque.get(2));
//        System.out.println(arrayDeque.size());
        int c = arrayDeque.get(1);
        assertEquals(3, a);
        assertEquals(1, c);
        assertEquals(9, b);
        arrayDeque.addLast(10);
        arrayDeque.addLast(190);
        int m = arrayDeque.get(arrayDeque.size() - 1);
        assertEquals(190, m);
    }
    @Test
    public void removeTest() {
        ArrayDeque<String> stringArrayDeque = new ArrayDeque<>();
        stringArrayDeque.addFirst("Banana");
        stringArrayDeque.addFirst("Apple");
        stringArrayDeque.addLast("watermelon");
        String s1 = stringArrayDeque.removeFirst();
        assertEquals("Apple", s1);
        stringArrayDeque.addLast("pear");
        String s2 = stringArrayDeque.removeLast();
        assertEquals("pear", s2);
        String s3 = stringArrayDeque.get(1);
        assertEquals("watermelon", s3);
    }
    @Test
    public void emptyTest() {
        ArrayDeque<String> stringArrayDeque = new ArrayDeque<>();
        stringArrayDeque.addFirst("Banana");
        stringArrayDeque.addFirst("Apple");
        stringArrayDeque.addLast("watermelon");
        boolean isEmpty1 = stringArrayDeque.isEmpty();
        assertFalse(isEmpty1);
        stringArrayDeque.removeFirst();
        stringArrayDeque.removeLast();
        boolean isEmpty2 = stringArrayDeque.isEmpty();
        assertFalse(isEmpty2);
        stringArrayDeque.removeFirst();
        boolean isEmpty3 = stringArrayDeque.isEmpty();
//        assertFalse(isEmpty3);
        assertTrue(isEmpty3);
    }
    @Test
    public void test() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(0);
        int i = arrayDeque.removeFirst();
        assertEquals(0, i);
        arrayDeque.addLast(2);
        int j = arrayDeque.removeFirst();
        assertEquals(2, j);
        arrayDeque.addLast(4);
    }
}
