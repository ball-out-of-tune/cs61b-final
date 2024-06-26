package synthesizer;
// TODO: Make sure to make this class a part of the synthesizer package
// package <package name>;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.first = 0;
        this.last = 0;
        fillCount = 0;

    }

    /**
    * when first == last, make them both at 0.
    */
    private void wrapAround() {
        first = 0;
        last = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (!isFull()) {
            rb[last] = x;
            last = (last + 1) % capacity;
            fillCount++;
        } else {
            throw new RuntimeException("Ring Buffer Overflow");
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (!isEmpty()) {
            T temp = rb[first];
            first = (first + 1) % capacity;
            fillCount--;
            if (first == last) {
                wrapAround();
            }
            return temp;
        } else {
            throw new RuntimeException("Ring Buffer Underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (!isEmpty()) {
            return rb[first];
        } else {
            throw new RuntimeException("Ring Buffer Underflow");
        }
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    public Iterator<T> iterator() {
        return new keyIterator();
    }

    private class keyIterator implements Iterator<T>{
        private int ptr;
        public keyIterator() {
            ptr = first;
        }
        public int minusOne(int x) {
            if (x != 0)
                return (x - 1);
            else
                return capacity - 1;
        }
        public boolean hasNext() {
            if (ptr <= minusOne(last) && ptr >= first) {
                return true;
            } else {
                return false;
            }
        }
        public T next() {
            if (hasNext()) {
                T temp = rb[ptr];
                ptr += 1;
                return temp;
            }
            else {
                return null;
            }
        }
    }
}
