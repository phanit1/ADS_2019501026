public class BST {
    Node root;
    class Node {
        int key;
        int val;
        Node left, right;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public int get(int key) {
        return get(root, key);
    }
    private int get(Node x, int key) {
        if (x == null) return -1;
        if (key < x.key) return get(x.left, key);
        else if (key > x.key) return get(x.right, key);
        else return x.val;
    }
    public void put(int key, int val) {
        root = put(root, key, val);
    }
    private Node put(Node x, int key, int val) {
        if (x == null) return new Node(key, val);
        if (key < x.key) x.left = put(x.left, key, val);
        else if (key > x.key) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }
    public int min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
    public void delete(int key) {
        root = delete(root, key);
    }
    private Node delete(Node x, int key) {
        if (x == null) return null;
        if (key < x.key) x.left  = delete(x.left,  key);
        else if (key > x.key) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        return x;
    }
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
public static void main(String[] args) {
    BST bst = new BST();
    bst.put(11, 111);
    bst.put(22, 222);
    System.out.println(bst.height());
    System.out.println(bst.get(11));
    bst.delete(11);
    System.out.println(bst.get(11));

}
}
