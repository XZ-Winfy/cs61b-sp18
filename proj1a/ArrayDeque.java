public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int front;
    private int end;
    private int length;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        front = 4;
        end = 5;
        length = 8;
    }

    public void addFirst(T item) {
        if (size == length - 1) {
            resize(size * 2);
        }
        array[front] = item;
        front = minusone(front);
        size += 1;
    }

    public void addLast(T item) {
        if (size == length - 1) {
            resize(size * 2);
        }
        array[end] = item;
        end = plusone(front, length);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int ptr = front;
        while (ptr != end) {
            System.out.println(array[ptr] + " ");
            ptr = plusone(ptr, length);
        }
    }

    public T removeFirst() {
        if (length >= 16 && size / length <= 0.25) {
            shrink(length / 2);
        }
        if (size == 0) {
            return null;
        }
        T ret = array[front];
        front = plusone(front, length);
        size -= 1;
        return ret;
    }

    public T removeLast() {
        if (length >= 16 && size / length <= 0.25) {
            shrink(length / 2);
        }
        if (size == 0) {
            return null;
        }
        T ret = array[end];
        end = minusone(end);
        size -= 1;
        return ret;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int ptr = front;
        for (int i = 0; i < index; i++) {
            ptr = plusone(ptr, length);
        }
        return array[ptr];
    }

    private int plusone(int i, int len) {
        if (i == len - 1) {
            return 0;
        }
        return i + 1;
    }

    private int minusone(int i) {
        if (i == 0) {
            return length - 1;
        }
        return i - 1;
    }

    private void resize(int s) {
        T[] a = (T[]) new Object[s];
        int p1 = front;
        int p2 = length;
        while (p1 != end) {
            a[p2] = array[p1];
            p1 = plusone(p1, length);
            p2 = plusone(p2, s);
        }
        front = minusone(length);
        end = p2 + 1;
        array = a;
        length = s;
    }

    private void shrink(int s) {
        T[] a = (T[]) new Object[s];
        int p1 = front;
        int p2 = length / 4;
        while (p1 != end) {
            a[p2] = array[p1];
            p1 = plusone(p1, length);
            p2 = plusone(p2, s);
        }
        front = minusone(length / 4);
        end = p2 + 1;
        array = a;
        length = s;
    }

}
