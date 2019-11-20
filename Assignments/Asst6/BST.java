/**.
 * This is to check the elements are in BST or not in the range of two user input keys
 * @author Phaneendhar
 */
import java.util.Scanner;
public class BST<Key extends Comparable<Key>, Value> {
    Node root;
    /**
     * Basic structure of a node
     */
    class Node {
        Key key;
        Value val;
        Node left, right;
        int size;
        public Node(Key key, Value val) {// parameterised constructor with key value
            this.key = key;
            this.val = val;
        }
    }
    public int size() {// it calls with root parameter.
        return size(root);
    }
    public int size(Node x) { // return number of nodes
        if (x == null) {
            return 0;
        }
        else {
            return x.size;
        }
    }
    public void put(Key key, Value val) { // inserting key value pairs
        root = put(root, key, val);
    }
    public Node put(Node x, Key key, Value val) { // inserting key value 
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);//comparing given key and node's key
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        }
        else if (cmp > 0) {
            x.right = put(x.right, key, val);
        }
        else {
            x.val   = val;
        }
        x.size = 1 + size(x.left) + size(x.right);// calculates size.
        return x;
    }
    public Key min() {// returns key of the minimum node
        return min(root).key;
    } 

    public Node min(Node x) { // returns minimum node
        if (x.left == null) { // if x has no left child
            return x;
        }
        else { // if x has left child then returns minimum most left node
            return min(x.left);
        }
    }
    public Key max() { // returns key of the maximum node
        return max(root).key;
    } 
    public Node max(Node x) {// returns maximum node
        if (x.right == null) { // if x has no right child
            return x;
        }
        else {// if x has right child then returns maximum most right node
            return max(x.right);
        } 
    }
    public boolean isOrdered(Key min, Key max) { // checks whether the elements are in between min and max 
        return isOrdered(root, min, max);
    }
    public boolean isOrdered(Node x, Key min, Key max) { // checks if elements are in between min and max using recursion
        if (x == null) {
            return true;
        }
        //returns false if keys are not in range of minimum and maximum keys
        else if ((min != null && x.key.compareTo(min) < 0) || (max != null && x.key.compareTo(max) > 0)) {
            return false;
        }
        else {// returns true if keys are in range of minimum and maximum keys
            return isOrdered(x.left, min, max) && isOrdered(x.right, min, max);
        }
    }
    public static void main(String[] args) {
        BST bst = new BST();// creating object for BST
        Scanner scan = new Scanner(System.in);// creating object for Scanner class
        System.out.println("Enter no. of nodes in BST:");
        int n = scan.nextInt();
        System.out.println("Enter key value pairs:");
        /**.
         * entering key value pairs
         */
        for(int i = 0; i<n;i++){
            String k = scan.next();
            int v = scan.nextInt();
            bst.put(k,v);
        }
        System.out.println("Minimum Key:"+bst.min());// minimum key 
        System.out.println("Maximum key:"+bst.max());// maximum key
        System.out.println("Are elements there in between min and max:"+bst.isOrdered(bst.min(), bst.max()));

    }
}