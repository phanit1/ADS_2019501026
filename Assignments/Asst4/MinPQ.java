public class MinPQ {
     int[] pq;
     int n;
    public MinPQ(int initCapacity) {
        pq = new int[initCapacity + 1];
        n = 0;
    }
    public boolean isEmpty() {
        return n == 0;
    }
   public int size() {
        return n;
    }
    public int min() {
        return pq[1];
    }
    public void insert(int x) {
        pq[++n] = x;
        swim(n);
    }
    public int delMin() {
        int min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = 0;
        return min;
    }
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    private boolean greater(int i, int j) {
        if(pq[i] > pq[j]) {
            return true;
        }
        else {
            return false;
        }
    }
    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
