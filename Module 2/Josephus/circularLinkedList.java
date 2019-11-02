/**.
 * This is used to perform circular linked list operations on Josephus problem
 * @author Phaneendhar
 */
/**.
 * Node class is used to store value, next value address , previous value address
 */
 class Node{
    int data;
    Node next;
    Node prev;
    Node(int val) {
        this.data = val;
    }
}
/**.
 * circularlinkedlist is used to perform circular linkedlist operations
 */
public class circularLinkedList {
    Node head;
    Node tail;
    public void add(int val) {
        Node node = new Node(val);
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    /**.
     * This is used to form circle at last
     */
    public void formCircle() {
        this.tail.next = this.head;
        this.head.prev = this.tail;
    }
}