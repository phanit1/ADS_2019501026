public class Deque {
    Node first;
    Node last;
    int size;
    class Node {
        String item;
        Node next;
        Node prev;
    }
    public void addFirst(String item) {
        Node newNode = new Node();
        newNode.item = item;
        size++;
        if (size == 1) {
            first = newNode;
            last = newNode;
        }
        else {
            Node tempFirst = first;
            first = newNode;
            newNode.next = tempFirst;
            tempFirst.prev = newNode;
        }
    }
    public void addLast(String item) {
        Node newNode = new Node();
        newNode.item = item;
        size++;
        if(size == 1) {
            first = newNode;
            last = newNode;
        }
        else {
            Node tempLast = last;
            last = newNode;
            newNode.prev = tempLast;
            tempLast.next = newNode;
        }
    }
    public String removeFirst() {
        String item = first.item;
        size--;
        first = first.next;
        if(size == 0) {
            last = null;
        }
        else {
            first.prev = null;
        }
        return item;
    }
    public String removeLast() {
        String item = last.item;
        size--;
        last = last.prev;
        if(size == 0 ){
            first = null;
        }
        else {
            last.next = null;
        }
        return item;
    }

    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.addFirst("44");
        deque.addFirst("11");
        deque.addFirst("55");
        deque.addLast("4");
        deque.addLast("1");
        deque.addLast("5");
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
    }
}