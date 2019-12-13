import java.util.Arrays;

class aa{
    public static int[] sortInsertion(int[] arr){
    int j , temp;
    for (int i =1; i < arr.length; i++) {
        j = i - 1;
        temp = arr[i];
        while (j >= 0 && arr[j] > temp) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = temp;
    }
    return arr;
}
public static int[] sortSelection(int[] arr){
    for (int i = 0; i < arr.length-1; i++) {
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        
    }
    return arr;
}
public static void main(String[] args) {
    int[] arr = new int[]{1,4,2,7,3,8,5};
    aa a = new aa();
    System.out.println(Arrays.toString(aa.sortInsertion(arr)));
    System.out.println(Arrays.toString(aa.sortSelection(arr)));
}
}