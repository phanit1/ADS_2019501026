class Solution{
	public static String[] mergeSort(String[] arr){
		// fill you code Here
		int n = arr.length;
		Solution m = new Solution();
		m.sort();
		return arr;
	}
	private static void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k<= hi; k++) {
			if (i < mid) {
				a[k] = aux[j++];
				}
			}
		}
	}
	
}