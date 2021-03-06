/**.
 * This solution is to sort the arrays using Insertion and Selection Sorting
 * @author Phaneendhar
 */
class Solution {
	/**
	 * This is used to sort array by insertion sorting
	 * @param arr , arr is the array to be sorted
	 * @return sorted array
	 */
	public int[] sortInsertion(int[] arr){
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
	/**.
	 * This is used to sort array by selection sorting
	 * @param arr , arr is the array to be sorted
	 * @return sorted array
	 */
	public int[] sortSelection(int[] arr){
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
}