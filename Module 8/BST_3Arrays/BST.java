/**
 * This is to implement BST and store key and value pairs and left and right
 * indices seperately in different arrays
 * @author Phaneendhar
 */
public class BST<Key extends Comparable<Key>, Value> {
    Key[] keys;
    Value[] values;
    int[] leftIndices;
    int[] rightIndices;
    int[] sizes;
    public BST() {
        this.keys = (Key[]) new Comparable[20];
        this.values = (Value[]) new Object[20];
        this.leftIndices = new int[20];
        this.rightIndices = new int[20];
        this.sizes = new int[20];
        for (int i = 0; i < 20; i++) {
            leftIndices[i] = -1;
            rightIndices[i] = -1;
        }
    }
    /**
     * gives size of the array based on key index
     */
    public int size(int keyIndex) {
        if (keyIndex == -1) {
            return 0;
        } else {
            return sizes[keyIndex];
        }
    }
    /**
     * gives number of key value pairs
     * @return number of key value pairs
     */
    public int size() {
        return sizes[0];
    }
    /**
     * This is to check whether BST is empty or not
     * @return true if BST is empty, false otherwise
     */
    public boolean isEmpty() {
        return keys[0] == null;
    }
    /**
     * Checks the given key in the keys array or not
     * @param key , key to be searched 
     * @return true if key is there, false otherwise
     */
    public boolean contains(Key key) {
        for (Key eachKey : keys) {
            if(eachKey.compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }
    /**
     * To get value based on the key
     * @param key , key to be searched to get value
     * @return value associated with the given key
     */
    public Value get(Key key) {
        return get(0, key);
    }
    public Value get(int keyIndex, Key keyToCompare) {
        if (keyIndex < 0) {
            return null;
        }
        int cmp = keyToCompare.compareTo(keys[keyIndex]);
        if (cmp < 0) {
            return get(leftIndices[keyIndex], keyToCompare);
        } else if (cmp > 0) {
            return get(rightIndices[keyIndex], keyToCompare);
        } else {
            return values[keyIndex];
        }
    }
    /**
     * This is to insert key value pairs
     * @param key , key to be inserted
     * @param val , value to be inserted associated with key
     */
    public void put(Key key, Value val) {
        put(0, key, val);
    }
    public int put(int keyIndex, Key keyToCompare, Value val) {
        if (keyIndex  == -1 || keys[keyIndex] == null) {
            keyIndex = size();
            keys[keyIndex] = keyToCompare;
            values[keyIndex] = val;
            sizes[keyIndex] = 1;
            return keyIndex;
        }
        int cmp = keyToCompare.compareTo(keys[keyIndex]);
        if(cmp < 0) {
            leftIndices[keyIndex] = put(leftIndices[keyIndex],  keyToCompare, val);       
        } else if (cmp > 0) {
            rightIndices[keyIndex] = put(rightIndices[keyIndex], keyToCompare, val);
        } else {
            values[keyIndex] = val;
        }
        sizes[keyIndex] = size(leftIndices[keyIndex]) + size(rightIndices[keyIndex]) + 1; 
        return keyIndex;
    }
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();
        bst.put("S",3);
        bst.put("E",5);
        bst.put("A",6);
        bst.put("R",1);
        bst.put("C",2);
        bst.put("H",7);
        bst.put("E",9);
        bst.put("X",10);
        bst.put("A",20);
        bst.put("M",12);
        bst.put("P",4);
        bst.put("L",15);
        bst.put("E",13);
        System.out.println(bst.get("P"));
    }
}
