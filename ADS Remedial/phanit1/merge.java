public class merge {
    public void copy_merge(int[] a, int[] aux, int low, int mid, int high) {
        for(int k = low; k<=high;k++) {
            aux[k] = a[k];
        }
        int i = low,j =mid+1;
        for (int k = low; k<=high;k++) {
            if(i>mid) {
                a[k] = aux[j++];
            }
            else if(j>high) {
                a[k] = aux[i++];
            }
            else if(aux[j] < aux[i]) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }
    public void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a,aux,0,a.length-1);
    }
    public void sort(int[] a,int[] aux,int low,int high) {
        if(high <= low) {
            return;
        }
        int mid = (low+high)/2;
        sort(a, aux, low, mid);
        sort(a, aux, mid+1, high);
        copy_merge(a, aux, low, mid, high);
    }
    public void display(int[] arr) {
        System.out.println("Sorted Array: ");
        for(int i = 0;i<arr.length;i++) {
            System.out.print(arr[i]+"  ");
        }
    }
    public static void main(String[] args) {
        merge m = new merge();
        int[] array = {77,11,44,22};
        m.sort(array);
        m.display(array);
    }
}