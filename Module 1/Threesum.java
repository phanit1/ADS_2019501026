/**.
 * This is to find three sum which means sum of three numbers must be equal to zero.
 * @author Phaneendhar 
 */
import java.util.*;
public class Threesum {
    public static void main(final String[] args) {
        /**.
         * count is used to know how many sums of the three numbers is zero
         */
        int count = 0;
        /**.
         * arr is the array of the elements in which we found the sum of three elements.
         */
        int[] arr = {1,-2, 3, -3, 0, 7, -5};
        /**.
         * sorting the array
         */
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int sum = -(arr[i] + arr[j]);
                int index = Arrays.binarySearch(arr, sum);
                if(i < j && j < index) {
                    System.out.println(arr[i] + "," + arr[j] + "," + arr[index]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
