/**.
 * This is to implement Binary Search Tree using tree data structure.
 * @author Phaneendhar
 */
import java.util.NoSuchElementException;
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    /**.
     * This is the structure of every node
     */
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    /**
     * To check whether symbol table is empty or not
     * @return true if it is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**.
     * To find number of key value pairs
     * @return number of key value pairs
     */
    public int size() {
        return size(root);
    }
    /**.
     * To find number of key value pairs at specific node
     * @param x , node 
     * @return number of key value pairs at specific node
     */
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    /**.
     * To check the key is there or not in symbol table
     * @param key , key to be searched
     * @return true if key is there, false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**.
     * This is to get value based on the key
     * @param key , key to be searched for returning value
     * @return value associated with the given key
     */
    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        }
        else if (cmp > 0) {
            return get(x.right, key);
        }
        else {
            return x.val;
        }
    }
    /**
     * This is to insert key value pairs
     * @param key , key to be inserted
     * @param val , value to be inserted with associated key
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        }
        else if (cmp > 0) {
            x.right = put(x.right, key, val);
        }
        else {
            x.val   = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    /**.
     * Deletes minimum key and associated value with it
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**.
     * Deletes maximum key and associated value with it.
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * Deletes the key value pair
     * @param key
     */
    public void delete(Key key) {
        root = delete(root, key);
    }
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = delete(x.left,  key);
        }
        else if (cmp > 0) {
            x.right = delete(x.right, key);
        }
        else { 
            if (x.right == null) {
                return x.left;
            }
            if (x.left  == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * Gives minimum key
     * @return minimum key
     */
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) { 
        if (x.left == null) {
            return x;
        } 
        else {
            return min(x.left);
        } 
    }
    /**
     * Gives maximum key
     * @return maximum key
     */
    public Key max() {
        return max(root).key;
    }
    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        else {
            return max(x.right);
        } 
    }
    /**
     * Checks the element lesser than key which is larger.
     * @param key , key which is to be found floor
     * @return largest key less than or equal to key
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    }
    /**
     * Checks the element greater than key which is smaller.
     * @param key , key which is to be found floor
     * @return smallest key greater than or equal to key
     */
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }
    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    }
    /**
     * Gives key whose rank is given key
     * @param k , key
     * @return key of rank
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
        }
        Node x = select(root, k);
        return x.key;
    } 
    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        } 
        int t = size(x.left); 
        if (t > k) {
            return select(x.left,  k);
        } 
        else if (t < k) {
            return select(x.right, k-t-1);
        } 
        else {
            return x;
        }
    }
    /**
     * Gives number of keys less than given key
     * @param key , key 
     * @return number of keys less than given key
     */
    public int rank(Key key) {
        return rank(key, root);
    }
    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key); 
        if (cmp < 0) {
            return rank(key, x.left);
        }
        else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } 
        else {
            return size(x.left);
        }
    }
    /**
     * Iterate keys and gives all the keys
     * @return all the keys
     */
    public Iterable<Key> keys() {
        if (isEmpty()) {
            return new Queue<Key>();
        }
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    }
    /**
     * Gives number of keys in given range
     * @param lo , lowest point
     * @param hi , highest point
     * @return number of keys between low and high points
     */
    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }
    /**
     * To find height of BST
     * @return height of BST
     */
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
}