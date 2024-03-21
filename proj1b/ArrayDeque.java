public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private int first;
    private int last;
    private int size;
    private int capacity;
    public ArrayDeque() {
        array = (T []) new Object[8];
        first = 4;
        last = 5;
        size = 0;
        capacity = 8;
    }
    private void setFirst(int x) {
        if (x < capacity) {
            this.first = x;
        }
    }
    private int plusOne(int x) {
        if (x < capacity - 1) {
            x++;
            return x;
        } else {
            return 0;
        }
    }

    private int minusOne(int x) {
        if (x != 0) {
            x--;
            return x;
        } else {
            return capacity - 1;
        }
    }

    private void grow() {
        T[] newArray = (T[]) new Object[2 * capacity];
        for (int i = 0; i <= capacity; i++) {
            first = plusOne(first);
            newArray[capacity / 2 + i] = array[first];
        }
        first = capacity / 2 - 1;
        last = capacity * 3 / 2;
        capacity *= 2;
        array = newArray;
    };

    private void shrink() {
        T[] newArray = (T[]) new Object[capacity / 2];
        for (int i = 0; i < size; i++) {
            first = plusOne(first);
            newArray[capacity / 4 + i] = array[first];
        }
        array = newArray;
        first = capacity / 4 - 1;
        last = capacity / 4 + size;
        capacity /= 2;
    }
    @Override
    public void addFirst(T item) {
        if (size == capacity) {
            grow();
        }
        array[first] = item;
        first = minusOne(first);
        size++;
    }
    @Override
    public void addLast(T item) {
        if (size == capacity) {
            grow();
        }

        array[last] = item;
        last = plusOne(last);
        size++;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            first = plusOne(first);
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }
    @Override
    public T removeFirst() {
        if (size <= capacity / 4 && capacity > 32) {
            shrink();
        }
        if (size != 0) {
            first = plusOne(first);
            T rm = array[first];
            size--;
            return rm;
        } else {
            return null;
        }
    }
    @Override
    public T removeLast() {
        if (size <= capacity / 4 && capacity > 32) {
            shrink();
        }
        if (size != 0) {
            last = minusOne(last);
            T rm = array[last];
            size--;
            return rm;
        } else {
            return null;
        }
    }
    @Override
    public T get(int index) {
        if (index < size) {
            return array[(first + 1 + index) % capacity];
        } else {
            return null;
        }
    }
}
