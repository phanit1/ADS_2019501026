import java.util.Scanner;
public class BSST {
    int[] keys;
    int[] vals;
    int n;
    public BSST(int capacity) {
        keys = new int[capacity];
        vals = new int[capacity];
    }
    public void put(int key,int val) {
        int i = rank(key);
        if(i<n && keys[i] == key) {
            vals[i] = val;
        }
        for(int j = n;j>i;j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    public int get(int key) {
        int i = rank(key);
        if(i<n && keys[i] == key) {
            return vals[i];
        }
        return -1;
    }
    public void delete(int key) {
        int i = rank(key);
        for(int j = i;j<n-1;j++) {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        n--;
        keys[n] = -1;
        vals[n] = -1;
    }
    public int rank(int key) {
        int lo=0,hi=n-1;
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            if(key < keys[mid]) {
                 hi = mid -1;
            }
            else if(key>keys[mid]) {
                lo = mid+1; 
            }
            else return mid;
        }
        return lo;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ENter no of elements:");
        int capacity = scan.nextInt();
        BSST bsst = new BSST(capacity);
        for(int i = 0; i < capacity ;i++) {
            int key = scan.nextInt();
            int val = scan.nextInt();
            bsst.put(key, val);
        }
        for(int i = 0; i < bsst.n; i++) {
            System.out.println(bsst.keys[i]+"--"+bsst.vals[i]);

        }
        
    }
}