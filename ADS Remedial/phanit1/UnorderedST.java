public class UnorderedST {
    int n;
    Node first;
    class Node {
        int key;
        int val;
        Node next;
        public Node(int key, int val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    public int get(int key) {
        for (Node x = first; x != null; x = x.next) {
            if (key==x.key)
                return x.val;
        }
        return -1;
    }
    public void put(int key, int val) {
        for (Node x = first; x != null; x = x.next) {
            if (key==x.key) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
    public void delete(int key) {
        first = delete(first, key);
    }
    Node delete(Node x, int key) {
        if (key == x.key) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
public static void main(String[] args) {
    UnorderedST ss = new UnorderedST();
    ss.put(11, 33);
    ss.put(22, 44);
    ss.put(1,88);
    ss.put(33,8);
    while(ss.first!=null) {
        System.out.println(ss.first.key+"---"+ss.get(ss.first.key));
        ss.first = ss.first.next;
    }
}
}