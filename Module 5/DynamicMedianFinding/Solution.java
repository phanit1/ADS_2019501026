/**.
 * This is to find medians of given array dynamically.
 * @author Phaneendhar
 */
class Solution{
	public static double[] dynamicMedian(double[] arr){
		int len = arr.length; // length of the given array
		double[] medians = new double[len]; // array to store medians
		int size = 0; // size of medians array
		double median = 0; // median keeping default as zero
		MinPQ<Double> minpq = new MinPQ<Double>(len);
		MaxPQ<Double> maxpq = new MaxPQ<Double>(len);
		for (int i = 0; i < len; i++) {
			if (arr[i] > median) { // checks element with median
				minpq.insert(arr[i]); // inserting element into minpq
			}
			else {
				maxpq.insert(arr[i]); // inserting element into maxpq
			}
			if (maxpq.size() - minpq.size() > 1) { // checks size difference is greater than 1 or not
				minpq.insert(maxpq.delMax()); // max val of max heap is inserted into min heap
			}
			if (maxpq.size() - minpq.size() < -1) { // checks size difference is less than -1 or not			
				maxpq.insert(minpq.delMin()); // min val of min heap is inserted into max heap
			}
			if (minpq.size() == maxpq.size()) { // checks size difference is zero or not
				median = (minpq.min() + maxpq.max()) / 2; //calculates average of min value of min heap and max value of max heap
				medians[size++] = median; // stores median into medians array and size is incremented
			}
			if (maxpq.size() > minpq.size()) { // if maxpq size is  greater than minpq size
                median = maxpq.max();
				medians[size++] = median; // storing max value of max heap into median and median into medians array
            }
            else if (minpq.size() > maxpq.size()) { // if minpq size is greater than maxpq size
                median = minpq.min();
				medians[size++] = median; // storing min value of min heap into median and median into medians array
			}
		}
		return medians; // resultant array of all medians
	}
}