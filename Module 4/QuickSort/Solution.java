/**.
 * This is to sort the array using QuickSort
 * @author Phaneendhar
 */
class Solution{
	public static int[] quickSort(int[] arr){
		// fill you code Here
        int n = arr.length; 
        Solution q = new Solution(); 
        q.sort(arr, 0, n-1); 
		return arr;
    }
    /**
     * This is used to partition the sorted and unsorted elements aside
     * @param arr , arr is the array to be sorted
     * @param low , low is the lowest index
     * @param high , high is the highest index
     * @return index where to partition the array
     */
	int partition(int arr[], int low, int high) {
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) { 
                i++; 
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        return i+1; 
    }
    /**
     * This is used to sort the partitioned unsorted elements of array
     * @param arr , arr is the array
     * @param low , low is the lowest index
     * @param high , high is the highest index
     */
    void sort(int arr[], int low, int high) { 
        if (low < high) { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high);
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
	
}