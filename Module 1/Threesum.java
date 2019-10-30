import java.util.*;
public class Threesum {
    public static void main(String[] args) {
        int count = 0;
        int[] arr = {30,-40,-20,-10,40,0,10,5};
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int sum = -(arr[i]+arr[j]);
                int index = Arrays.binarySearch(arr, sum);
                if(i < j && j < index) {
                    System.out.println(arr[i]+","+arr[j]+","+arr[index]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}