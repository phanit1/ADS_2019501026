public class MaxPQB {
    int[] pq;
    int n = 0;
    public MaxPQB(int capacity) {
        pq = new int[capacity];
    }
    public void insert(int x) {
        pq[++n] = x;
        swim(n);
    }
    public void swim(int k) {
        while(k>1 && pq[k/2] < pq[k]) {
            exch(k,k/2);
            k = k/2;
        }
    }
    private void exch(int k, int i) {
        int temp = pq[k];
        pq[k] = pq[i];
        pq[i] = temp;
    }

    public int delMax() {
        int max = pq[1];
        exch(1,n--);
        sink(1);
        pq[n+1] = -1;
        return max;
    }
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && pq[j]< pq[j+1]) j++;
            if (pq[k]>pq[j]) break;
            exch(k, j);
            k = j;
        }
    }
    public static void main(String[] args) {
        MaxPQB mPqb = new MaxPQB(10);
        mPqb.insert(12);
        mPqb.insert(13);
        mPqb.insert(44);
        mPqb.insert(33);
        System.out.println(mPqb.delMax());
        System.out.println(mPqb.delMax());
    }
    
}