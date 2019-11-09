import java.util.Iterator;
import java.util.NoSuchElementException;
public class Queue<Item> implements Iterable<Item> {
    public Node<Item> first; 
    public Node<Item> last;     
    public int n;

    public static class Node<Item> {
        public Item item;
        public Node<Item> next;
    }
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    public Iterator<Item> iterator()  {
        return new ListIterator(first);  
    }
    public class ListIterator implements Iterator<Item> {
        public Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}