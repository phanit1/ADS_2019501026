/**.
 * This program is to merge two sorted arrays into one array.
 * @author Phaneendhar
 */
class Array {
    public static void main(String [] args){
        /**.
         * arr1 is one sorted array.
         */
        int [] arr1 = {1,2,7};
        /**.
         * arr2 is another sorted array
         */
        int [] arr2 = {3,5,6};
        /**.
         * l1 is the length of the array arr1.
         */
        int l1 = arr1.length;
        /**.
         * l2 is the length of array arr2
         */
        int l2 = arr2.length;
        /**.
         * arr3 is the array of total elements of arr1 and arr2 of length l1 and l2.
         */
        int [] arr3 = new int[l1+l2];
        int i = 0, j = 0, k = 0, x;
        /**.
         * It checks till the last indexes of arrays of equal length
         */
        while(i < l1 && j < l2){
            if(arr1[i] < arr2[j]){
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }
        /**.
         * It checks till last index of arr1
         */
        while(i < l1){
            arr3[k++] = arr1[i++];
        }
        /**.
         * It checks till last index of arr2
         */
        while (j < l2){
            arr3[k++] = arr2[j++];
        }
        /**.
         * It prints the every element of arr3
         */
        for(x = 0; x < l1+l2; x++){
            System.out.print(""+arr3[x]+ " ");
        }
    }
}