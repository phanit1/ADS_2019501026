/**.
 * This is to print k largest elements after deleting N - k elements where there are n elements in an array.
 * @author Phaneendhar
 */
import java.util.Arrays;
import java.util.Scanner;
public class Asst4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);//creating object of scanner
        System.out.println("Enter size of an array:");
        int N = scan.nextInt();// enter size of array
        int[] arr = new int[N]; // creating array of size N
        System.out.println("Enter elements:");
        for(int i = 0; i < N; i++) {//entering elements into array
            arr[i] = scan.nextInt();
        }
        System.out.println("Enter k value:");
        int k = scan.nextInt();// k value
        MinPQ minpq = new MinPQ(arr.length);// creating object for minpq
        for(int i = 0; i < N;i++) {
            minpq.insert(arr[i]);// insert N elements into minpq
        }
        for(int i = 0;i<(N-k);i++) {
            minpq.delMin();// delete N-k elements
        }
        System.out.println("K Maximum Elements:");
        for(int i = 1;i <= k;i++) {
            System.out.println(minpq.pq[i]); // printing k largest elements
        }
     }
}