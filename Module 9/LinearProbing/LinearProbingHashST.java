/**
 * This is to implement Linear Probing
 * @author Phaneendhar
 */
public class LinearProbingHashST<Key, Value> {
    public static final int INIT_CAPACITY = 10;
     int n = 0;
     int m;
     Key[] keys;
     Value[] vals;
    /**.
     * A constructor to initialise symbol table as empty
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * A constructor to initialize symbol table with the specified capacity.
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        m = capacity;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * Gives the number of key-value pairs
     * @return the number of key-value pairs
     */
    public int size() {
        return n;
    }
    /**
     * To check whether Symbol Table is empty or not
     * @return true if symbol table is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * Checks the given key in the keys array or not
     * @param key , key to be searched 
     * @return true if key is there, false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * To find the index where the key to be inserted
     * @param key , key which is to be isnerted
     * @return index where the key to be inserted
     */
    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    /**
     * This is to insert key value pairs
     * @param key , key to be inserted.
     * @param val , value to be inserted associated with the key.
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    /**
     * This is to get the value of the given key
     * @param key , key to get the value
     * @return value associated with the given key
     */
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }
    /**
     * This is to delete key value pair by key
     * @param key , key to be deleted
     */
    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % m;
        while (keys[i] != null) {
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;
    }
    /**
     * Iterate and get all the keys
     * @return all the keys
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }    
    public static void main(String[] args) { 
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        st.put("P", 26);
        st.put("A", 5);
        st.put("B", 8);
        st.put("C", 12);
        st.put("D", 13);
        st.put("U", 4);
        for (String s : st.keys()) 
            System.out.println("[" +s + "-" + st.get(s) +"]"); 
    }
}