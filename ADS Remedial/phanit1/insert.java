public class insert {
    public int[] sort(int[] arr) {
        int n = arr.length;
        for(int i = 0;i<n;i++) {
            for(int j = i;j>0;j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else {
                    break;
                }
            }
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
        insert ins = new insert();
        int[] arr = {88,1,44,2,55};
        ins.sort(arr);
        ins.display(arr);
    }
}