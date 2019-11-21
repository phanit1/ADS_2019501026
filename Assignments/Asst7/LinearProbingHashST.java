/**
 *  To estimate the probability that all positions with indices divisible by 100 are occupied using Linear Probing
 * 
 * @author Phaneendhar
 */
import java.util.Random;

public class LinearProbingHashST {

    public static final int INIT_CAPACITY = 1000000;
    
     int n = 0;
     int m;
     int[] keys;
     int[] vals;
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
        keys = new int[m];
        vals = new int[m];
    }
    /**
     * Gives the number of key-value pairs
     * @return the number of key-value pairs
     */
    public int size() {
        return n;
    }
    /**
     * To find the index where the key to be inserted
     * @param key , key which is to be isnerted
     * @return index where the key to be inserted
     */
    public int hash(Integer key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    /**
     * This is to insert key value pairs
     * @param key , key to be inserted.
     * @param val , value to be inserted associated with the key.
     */
    public void put(int key, int val) {
        int i;
        for (i = hash(key); keys[i] != 0; i = (i + 1) % m) {
            if (keys[i]==(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    /**
     * To check every 100th index's key is zero or not 
     * @return
     */
    public int isHundNull() {
        int count = 0;
        for(int i = 0; i < keys.length; i+=100) {
            if(keys[i]!=0) { //if 100th index key is not equal to zero, increment count
                count++;
            }
        } return count;
    }
    public static void main(String[] args) { 
        LinearProbingHashST st = new LinearProbingHashST(INIT_CAPACITY);// creating object for linearprobing hashing
        Random rand = new Random();// creating object for random class
        for(int i = 0; i < INIT_CAPACITY/2;i++) {
            int k = rand.nextInt(1000000);// getting random values for keys
            int v = rand.nextInt(1000000);// getting random values for values
            st.put(k, v);
        }
        int countt= st.isHundNull();
        System.out.println("Probability is :"+(double)countt/INIT_CAPACITY);// printing probability 
    }
}