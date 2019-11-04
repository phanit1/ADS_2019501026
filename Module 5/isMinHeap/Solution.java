/**.
 * This is to find whether given array is min heap or not.
 * @author Phaneendhar
 */
class Solution{
	/**
	 * This is the function to return true when array is min heap or false
	 * @param arr , array to be checked for min heap
	 * @return true if arr is min heap or false
	 */
	public static boolean isMinHeap(double[] arr) {
		int len = arr.length;
		if (len == 0) {
			return false;
		}
		/**.
		 * Checks throughout the loop till length of the array
		 */
		for (int i = 0; i < len; i++) {
			/**.
			 * to check till the last child node occurs
			 */
			if ( (2*i + 1) < len && (2*i +2) < len) {
				/**.
				 * checks parent nodes and child nodes
				 */
				if (arr[i] > arr[2*(i)+1]  && arr[i] > arr[(2*(i) + 2)]) {
					return false;
				}
			}
		}
		return true;
	}
}