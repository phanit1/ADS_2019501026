/**.
 * This is to implement queue with circular linkedlist with only one pointer.
 * @author Phaneendhar
 */
public class Asst2 {
    public class Node {//structure of the node.
        int item;
        Node next;
        public Node(int item) {//initialsing values in node
            this.item = item;
            this.next = null;
        }
        public String toString() { // to print 
            return "Inserting item:"+item;
        }
    }
    int size = 0;
    Node rear = null;
    /**
     * This is to enqueue an item into queue.
     * @param item , item to be enqueued
     */
    public void enqueue(int item) {
        Node last = new Node(item);
        last.item = item;
        if (rear == null) { // if node is empty
            rear = last;
            rear.next = last;
            size++;
        }
        else { // if node is not empty
            Node oldLast = rear;
            rear = last;
            rear.next = oldLast.next;
            oldLast.next = rear;
            size++;
        }
    }
    /**
     * This is to dequeue the first inserted item
     * @return dequeued item
     */
    public int dequeue() {
        if (size == 0) { // empty queue
            return 0;
        }
        if(size == 1)  { // queue containing only one element
            int oldLast = rear.item;
            rear.next = null;
            size--;
            rear = null;
            return oldLast;
        }
        else { // queue containing more than one element
            int oldLast = rear.next.item;
            rear.next = rear.next.next;
            size--;
            return oldLast;
        }
    }
    public static void main(String[] args) {
        Asst2 q = new Asst2();
        q.enqueue(21); // to enqueue
        System.out.println(q.rear); // to print enqueued item
        q.enqueue(31);
        System.out.println(q.rear);
        q.enqueue(44);
        System.out.println(q.rear);
        System.out.println("Deleted Item:"+q.dequeue());// to print dequeued item
        System.out.println("Deleted Item:"+q.dequeue());
        System.out.println("Deleted Item:"+q.dequeue());
        System.out.println("Deleted Item:"+q.dequeue());
    }
}