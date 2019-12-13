public class select {
    public int[] sort(int[] arr) {
        int n = arr.length;
        for(int i = 0;i<n;i++) {
            int min =i;
            for(int j= i;j<n;j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min]= arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    public void display(int[] arr) {
        System.out.println("Sorted Array: ");
        for(int i = 0;i<arr.length;i++) {
            System.out.print(arr[i]+"  ");
        }
    }
    public static void main(String[] args) {
        select sel = new select();
        int[] arr = {2,1,5,3,7};
        sel.sort(arr);
        sel.display(arr);
    }
}