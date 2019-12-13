import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private class Node<Item> {
        Item value;
        private Node<Item> prev;
        private Node<Item> next;
        Node(Item i) {
            value = i;
        }
    }
    private Node<Item> first;
    private Node<Item> last;
    private int size;
    public RandomizedQueue() {
        size = 0;    
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> obj = new Node<Item>(item);
        if(first == null && last == null) {
            first = obj;
            last = obj;
        }
        else {
            last.next = obj;
            obj.prev = last;
            last = obj;
        }
        size++;
    }
    public Item dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Random r = new Random();
        int randIndex = r.nextInt(size);
        Node<Item> temp = first;
        for (int i = 0; i < randIndex; i++) {
            temp = temp.next;
        }
        if(last == temp && temp == first) {
            first = null;
            last = null;
        }
        else if(temp == first) {
            first = temp.next;
        }
        else if(temp == last) {
            last = last.prev;
            last.next = null;
        }
        if(temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if(temp.prev != null) {
            temp.prev.next = temp.next;
        }
        size--;
        return temp.value;

    }
    public Item sample() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        Random r = new Random();
        int randIndex = r.nextInt(size);
        Node<Item> temp = first;
        for (int i = 0; i < randIndex; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first); 
    }
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> recentNode;
        public ListIterator(Node<Item> first) {
            recentNode = first;
        }
        public boolean hasNext() {
            return recentNode!=null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<Item> temp = recentNode;
            temp = temp.next;
            return temp.value;
        }
    }
    public static void main(String[] args) {
        
    }

}