public class OrderedSST {
    static final int INIT_CAPACITY = 10;
    int[] keys;
    int[] vals;
    int n = 0;
    public OrderedSST(int capacity) { 
        keys = new int[capacity]; 
        vals = new int[capacity]; 
    }
    public int get(int key) {
        int i = rank(key); 
        if (i < n && keys[i]==key) return vals[i];
        return -1;
    } 
    public int rank(int key) {
        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
            int mid = (lo + hi)/ 2; 
            if      (key < keys[mid]) hi = mid - 1; 
            else if (key > keys[mid]) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    }
    public void put(int key, int val)  {
        if (val == -1) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < n && keys[i]==key) {
            vals[i] = val;
            return;
        }
        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    } 
    public void delete(int key) {
        int i = rank(key);
        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        n--;
        keys[n] = -1;
        vals[n] = -1;
    }
public static void main(String[] args) {
    OrderedSST ss = new OrderedSST(10);
    ss.put(5, 111);
    ss.put(99, 222);
    ss.put(4, 444);
    ss.put(1, 767);
    ss.delete(99);
    for (int i = 0; i < ss.n; i++) {
        System.out.println(ss.keys[i]+"---"+ss.vals[i]);
    }
}
}
