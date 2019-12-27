public class quick {
    public int partition(int[] a,int low,int high) {
        int i = low,j = high+1;
        while(true) {
            while(a[++i]<a[low]) {
                if(i == high) {
                    break;
                }
            }
            while(a[low] < a[--j]) {
                if(j==low) {
                    break;
                }
            }
            if(i>=j) break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[low];
        a[low] = a[j];
        a[j] = temp;
        return j;
        }
        public void sort(int[] a) {
            sort(a,0,a.length-1);
        }
        public void sort(int[] a,int low,int high) {
            if(high <= low) {
                return;
            }
            int j = partition(a, low, high);
            sort(a, low, j-1);
            sort(a,j+1,high);
        }
        public void display(int[] arr) {
            System.out.println("Sorted Array: ");
            for(int i = 0;i<arr.length;i++) {
                System.out.print(arr[i]+"  ");
            }
        }
        public static void main(String[] args) {
            quick q = new quick();
            int[] array = {1,5,2,7,3,4};
            q.sort(array);
            q.display(array);
        }
}