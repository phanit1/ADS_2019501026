/**.
 * This is to implement Sequential Search Symbol Table using Linked List.
 * @author Phaneendhar
 */
import java.util.Comparator;
public class SequentialSearchST<Key extends Comparable<Key>, Value> {
     int n;
     Node first;
    public class Node {
         Key key;
         Value val;
         Node next;
        /**
         * This is a parameterised c onstructor
         * @param key , key which can be anything but unique
         * @param val , value which is stored with key.
         * @param next , next immediate key
         */
        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    /**
     * size function is used to store number of key value pairs
     * @return number of key value pairs
     */
    public int size() {
        return n;
    }
    /**
     * This function is used to check whether linked list is empty or not
     * @return true if size is zero otherwise false
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * This is to find whether key is there in LinkedList or not
     * @param key , to be checked whether it is there or not
     * @return true if key is there otherwise false if key is not there
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * This is to update the link to the nodes when a node is deleted
     * @param recentNode , recent node which is to be linked
     * @return value which should be updated 
     */
    private  Value update(Node recentNode) {
        Node temp = recentNode.next;
        Value value = temp.val;
        recentNode.next = recentNode.next.next;
        Node node = first;
        while (node.next != null) {
            node = node.next;
        }
        node.next = temp;
        temp.next = null;
        return value;
    }
    /**
     * This is to get the value of the key when key is given as parameter.
     * @param key , key to be searched to get the value
     * @return value of the searched key
     */
    public Value get(Key key) {
        if (key == null) {
            return null;
        }
        if(first.key.compareTo(key) == 0) {
            return update(first);
        }
        Node recentNode = first;
        while(recentNode != null) {
            if (recentNode.next.key.compareTo(key) == 0) {
                return update(recentNode);
            }
            recentNode = recentNode.next;
        }
        return null;
    }
    /**
     * This is to put or insert key value pair into the linked list
     * @param key , the key to  be inserted into the linked list
     * @param val , the value to be inserted into the linked list based on the key
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
    /**
     * This is to store the key and its value which is to be deleted at beginning
     * @param key
     */
    public void delete(Key key) {
        first = delete(first, key);
    }
    /**
     * This is to delete the node based on the key
     * @param x , the node to be deleted
     * @param key , the key which is used to delete the node
     * @return the node which is to be deleted.
     */
    public Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
    /**
     * Iterate and get all the keys
     * @return all the keys
     */
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node temp = first; temp != null; temp = temp.next)
            queue.enqueue(temp.key);
        return queue;
    }
}