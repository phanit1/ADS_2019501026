/**.
 * This is the solution to sort array of strings using merge sort
 * @author Phaneendhar
 */
class Solution {
	public static String[] mergeSort(final String[] arr) {
		// fill you code Here
		/**.
		 * aux is used to copy the given array into it.
		 */
		String[] aux = new String[arr.length];
		/**.
		 * sort() is used to sort the array
		 */
		sort(arr, aux, 0, arr.length - 1);
		return arr;
	}
	/**.
	 * merge function is used to merge the sub sorted arrays
	 * @param a , a is the given array
	 * @param aux , aux is the copied array which is used to perform merging
	 * @param lo , lo is the lowest index
	 * @param mid , mid is the middle index
	 * @param hi , hi is the highest index 
	 */
	public static void merge(final String[] a, final String[] aux,
	final int lo, final int mid, final int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		/**.
		 * i is the lowest index of divided subarray
		 */
		int i = lo;
		/**.
		 * j is the highest index of divided subarray
		 */
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}
	/**
	 * This is to compare the strings 
	 * @param a , a string of index j of aux array
	 * @param b , a string of index i of aux array
	 * @return boolean value 1 or 0
	 */
	public static boolean less(final String a, final String b) {
		/**.
		 * this returns boolean value true or false by comparing a and b.
		 */
		return a.compareTo(b) < 0;
	}
	/**
	 * This is used to sort the sub arrays
	 * @param a , a sub array
	 * @param aux , another sub array
	 * @param lo , lowest index
	 * @param hi , highest index
	 */
	public static void sort(final String[] a, final String[] aux,
	final int lo, final int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = (hi + lo) / 2;
		/**.
		 * calling sort which is used to sort the divided subarrays.
		 */
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		/**.
		 * calling merge which is used to merge the sorted subarrays.
		 */
		merge(a, aux, lo, mid, hi);
	}
}
