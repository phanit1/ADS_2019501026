/**.
 * This is to implement Binary Search Symbol Table using arrays.
 * @author Phaneendhar
 */
import java.util.*;
class BinarySearchST<Key extends Comparable<Key>, Value> {
    Key[] keys;
    Value[] values;
    int n = 0;
    int size = 1;
    /**.
     * This is  a default constructor 
     */
    BinarySearchST() {
        keys = (Key[]) new Comparable[1];
        values = (Value[]) new Object[1];
        n = 0;
    }
    /**
     * To find number of key value pairs
     * @return number of key value pairs
     */
    public int size() {
        return n;
    }
    /**
     * This is to resize the array
     * @param size , the size of the array declared
     */
    public void resize(int size) {
        Key[]   tempKey = (Key[])   new Comparable[size];
        Value[] tempValue = (Value[]) new Object[size];
        for (int i = 0; i < n; i++) {
            tempKey[i] = keys[i];
            tempValue[i] = values[i];
        }
        values = tempValue;
        keys = tempKey;
    }
    /**
     * To check whether array is empty or not
     * @return true if array is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * To check the array has given key or not
     * @param key , key to be searched 
     * @return true if key is in array, false otherwise 
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * To get the value based on the key
     * @param key , key to be searched 
     * @return value associated with the key
     */
    public Value get(Key key) {
        if(isEmpty())
            return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0)
            return values[i];
        return null;
    }
    /**
     * This is used to insert key and value pairs
     * @param key , key to be inserted
     * @param value , value to be inserted associated to key
     */
    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        if (n == keys.length)
            resize(keys.length * 2);
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }
    /**
     * To find number of keys less than the given key
     * @param key , the key which is searched
     * @return number of keys less than given key
     */
    public int rank(Key key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int toCompare = key.compareTo(keys[mid]);
            if (toCompare < 0)
                hi = mid - 1;
            else if (toCompare > 0)
                lo = mid + 1;
            else 
                return mid;
        }
        return lo;
    }
    /**
     * This is to delete key value pair based on given key
     * @param key , the key to be deleted
     */
    public void delete(Key key) {
        int i = rank(key);

        for (int j = i; j < n - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        n--;
        keys[n] = null;
        values[n] = null;
    }
    /**
     * Used to delete minimum element
     */
    public void deleteMin() {
        delete(min());
    }
    /**.
     * Used to delete maximum element
     */
    public void deleteMax() {
        delete(max());
    }
    /**
     * Gives maximum element
     * @return maximum element
     */
    public Key max() {
        return keys[n - 1];
    }
    /**
     * Gives minimum element
     * @return minimum element
     */
    public Key min() {
        return keys[0];
    }
    /**
     * Checks the element lesser than key which is larger.
     * @param key , key which is to be found floor
     * @return largest key less than or equal to key
     */
    public Key floor(Key key) {
        int i = rank(key);
        if (i == 0) 
            return null;

        else if (i < n && key.compareTo(keys[i]) == 0) 
            return keys[i];
        else 
            return keys[i-1];
    }
    /**
     * This is used to return all keys
     * @return all keys
     */
    public String keys() {
        String k = "";
        for (int i = 0; i < n; i++) {
            k += keys[i] + " ";
        }
        return k;
    }
}