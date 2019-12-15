public class insert_sentinel {
    public static void insertionSort(int[] array) {
        int arraySentinel[] = new int[array.length+1];
        for(int i = 0; i < array.length; i++){
            arraySentinel[i+1] = array[i];
        }
        for (int i = 1; i < arraySentinel.length; i++) {
                int temp = arraySentinel[i];
                int j = i;
                while (arraySentinel[j - 1] > temp) {
                    arraySentinel[j] = arraySentinel[j - 1];
                    j--;
                }
                arraySentinel[j] = temp;                
        }
        for (int i = 1; i < arraySentinel.length; i++){
            array[i-1] = arraySentinel[i];
        }
    }
    public static void display(int[] arr) {
        System.out.println("Sorted Array: ");
        for(int i = 0;i<arr.length;i++) {
            System.out.print(arr[i]+"  ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {88,1,4,2,55};
        insertionSort(arr);
        display(arr);
    }
}