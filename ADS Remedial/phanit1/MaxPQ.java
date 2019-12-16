public class MaxPQ{
    int[] pq;
    int n;
    int min = Integer.MAX_VALUE;
    public MaxPQ(int initCapacity) {
        pq = new int[initCapacity + 1];
        n = 0;
    }
    public void min() {
        if(isEmpty()) {
            System.out.println("No PQ");
        }
        else {
            System.out.println(min);
        }
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    public int max() {
        return pq[1];
    }
    public void insert(int x) {
        if(min>x) {
            min = x;
        }
        pq[++n] = x;
        swim(n);
    }
    public int delMax() {
        int max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = -1;
        return max;
    }
    void swim(int k) {
        while (k > 1 && pq[k/2]<pq[k]) {
            exch(k, k/2);
            k = k/2;
        }
    }
    void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && pq[j]< pq[j+1]) j++;
            if (pq[k]>pq[j]) break;
            exch(k, j);
            k = j;
        }
    }
    void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    public static void main(String[] args) {
     MaxPQ mPq = new MaxPQ(10);
     mPq.insert(11);
     mPq.insert(33);
     mPq.insert(2);
     mPq.min(); 
    }
}