/**.
 * This is to find the farthest pair in an array of elements.
 * @author Phaneendhar
 */
import java.util.Scanner;
public class Asst1 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);// creating object to use Scanner class methods
        System.out.println("Enter size of array:");
        int N = scan.nextInt();// n is size of array which we give as input.
        while(true) {// for iterating and giving an input when wrong input is given
            if(N<=1) {
                System.out.println("There is no array.\nPlease enter another value:");
                N = scan.nextInt();// again giving input size for array
            }
            else {
                break;// to break and to give array elements.
            }
        }
        double[] a = new double[N];// initialising an array
        /**.
         * Giving array elements one by one
         */
        System.out.println("Enter array elements:");
        for(int i = 0; i < N; i ++) {
            a[i] = scan.nextDouble();
        }
        double max = a[0], min = a[0];
        /**.
         * for iterating and getting maximum and minimum elements.
         */
        for (int i = 0; i < N; i++) {
            if(max< a[i]) { // checking for maximum element
                max = a[i];// storing maximum element into max
            }
            if(min > a[i]) { // checking for minimum element
                min = a[i]; // storing minimum element into min
            }
        }
        System.out.println("Farthest pair is ("+max+","+min+")");// printing the farthest pair of elements
    } 
    }