public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node(T i, Node pre, Node nxt) {
            item = i;
            prev = pre;
            next = nxt;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node((T) new Object(), null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.println(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T f = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return f;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T l = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return l;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node ptr = sentinel;
        for (int i = 0; i <= index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecurHelp(sentinel.next, index);
    }

    private T getRecurHelp(Node n, int index) {
        if (index == 0) {
            return n.item;
        }
        return getRecurHelp(n.next, index - 1);
    }
}
