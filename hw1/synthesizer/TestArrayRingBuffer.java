package synthesizer;
import org.junit.Test;

import javax.print.DocFlavor;
import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
    }

    @Test
    public void test1() {
        ArrayRingBuffer<Integer> integerArrayRingBuffer = new ArrayRingBuffer<>(2);
        integerArrayRingBuffer.enqueue(1);
        integerArrayRingBuffer.enqueue(2);
        boolean actual = integerArrayRingBuffer.isFull();
        assertTrue(actual);
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Integer> integerArrayRingBuffer = new ArrayRingBuffer<>(4);
        integerArrayRingBuffer.enqueue(5);
        integerArrayRingBuffer.enqueue(32);
        integerArrayRingBuffer.enqueue(16);
        integerArrayRingBuffer.enqueue(100);
        Iterator<Integer> integerIterator = integerArrayRingBuffer.iterator();
        System.out.println(integerIterator.hasNext());
        for (int integer : integerArrayRingBuffer) {
            System.out.println(integer);
        }
    }

    @Test
    public void testThrowMethod1() {
        ArrayRingBuffer<Integer> integerArrayRingBuffer = new ArrayRingBuffer<>(3);
        integerArrayRingBuffer.dequeue();
    }
    @Test
    public void testThrowMethod2() {
        ArrayRingBuffer<Integer> integerArrayRingBuffer = new ArrayRingBuffer<>(3);
        integerArrayRingBuffer.enqueue(1);
        integerArrayRingBuffer.enqueue(2);
        integerArrayRingBuffer.enqueue(5);
        integerArrayRingBuffer.enqueue(10);
    }
    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
