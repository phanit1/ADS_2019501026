import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {

        Item item;
        Node next;
        Node prev;
    }

    public Deque() {

    }
    public boolean isEmpty() {

        return size()==0;

    }
    public int size() {

        return size;

    }
    public void addFirst(Item item) {

        if(item == null) {

            throw new NullPointerException("Cant add elements");
            
        }
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
    public void addLast(Item item) {
        if(item == null) {
            throw new NullPointerException("Cant add elements");
        }
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
    public Item removeFirst() {
        if(size() == 0) {
            throw new NoSuchElementException("Empty dequeue");
        }
        Item item = first.item;
        size--;
        first = first.next;
        if(size() == 0) {
            last = null;
        }
        else {
            first.prev = null;
        }
        return item;
    }
    public Item removeLast() {
        if(size() == 0) {
            throw new NoSuchElementException("Empty dequeue");
        }
        Item item = last.item;
        size--;
        last = last.prev;
        if(size() == 0 ){
            first = null;
        }
        else {
            last.next = null;
        }
        return item;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current!= null;
        }
        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
        // public void remove() {
        //     throw new UnsupportedOperationException("Remove is not allowed");
        // }

    }
    public static void main(String[] args) {
        
    }
}