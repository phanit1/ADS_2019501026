/**.
 * This is to implement BSST put operation in constant time for single insertion
 * and all elements in linear time.
 * @author Phaneendhar
 */
import java.util.*;
public class BSST<Key extends Comparable<Key>,Value> {
    Key[] keys;// array to store keys
    Value[] vals;//array to store values
    int n = 0;
    public BSST(int capacity) { // initialise size with capacity
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }
    public int size() { // return size
        return n;
    }
    public boolean isEmpty() { // checks empty or not
        return size() == 0;
    }
    /**
     * gives the number of keys less than given key
     */
    public int rank(Key key) {
        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
            int mid = (lo + hi) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1; 
            else if (cmp > 0) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 
    /**
     * This is to insert put key value pair
     * @param key , key to be inserted
     * @param val , value to be inserted
     */
    public void put(Key key, Value val)  {
        if (val == null) { // deletes key if value is not there
            delete(key);
            return;
       }
       if(size()==0) { // if size is empty directly insert key value pair
           keys[n] = key;
           vals[n] = val;
           n++;
       }
       else {
           /**
            * if last element is lesser than given key,insert directly key value pair next to last element 
            */
           if(key.compareTo(keys[n-1]) > 0) { 
               keys[n] =key;
               vals[n] = val;
           }
           /**.
            * if last element is greater than given key, insert key value pairs using rank
            */
            int i = rank(key);
            if (i < n && keys[i].compareTo(key) == 0) {
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
    }
    /**
     * This is to delete the key value pair
     * @param key , key to be deleted
     */
    public void delete(Key key) {
        if (isEmpty()) return;
        int i = rank(key);
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        n--;
        keys[n] = null;
        vals[n] = null;
    } 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// creating object to Scanner class
        System.out.println("Enter no.of key value pairs:");
        int n = scan.nextInt();// no of key value pairs
        BSST bsst = new BSST(n);
        System.out.println("Enter key value pairs:");
        for(int i = 0;i<n;i++) {// entering key value pairs one by one 
            int k = scan.nextInt();
            String v = scan.nextLine();    
            bsst.put(k,v);// inserting entered key value pairs into bsst
            }
        System.out.println("Sorted key value pairs:");
        for(int i = 0; i<n;i++) {
            System.out.println(bsst.keys[i]+" -"+bsst.vals[i]);// to print key value pairs in sorted order
        }
    }
}