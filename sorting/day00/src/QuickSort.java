public class QuickSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {

        quickSort(array, 0,array.length - 1);

        return array;
    }

    /**
     * Partition the array around a pivot, then recursively sort the left and right
     * portions of the array. A test for this method is provided in `SortTest.java`
     * Optional: use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * @param low The beginning index of the subarray being considered (inclusive)
     * @param high The ending index of the subarray being considered (inclusive)
     */
    public void quickSort(int[] a, int low, int high) {
        if(high-low > 0){
            int mid = partition(a,low,high);
            quickSort(a, low,mid-1);
            quickSort(a,mid+1,high);
        }


    }

    /**
     * Given an array, choose the array[low] element as the "pivot" element.
     * Place all elements smaller than "pivot" on "pivot"'s left, and all others
     * on its right. Return the final position of "pivot" in the partitioned array.
     *
     * @param low The beginning index of the subarray being considered (inclusive)
     * @param high The ending index of the subarray being considered (inclusive)
     */
    public int partition(int[] array, int low, int high) {
        // TODO
        while(low < high){
            if(array[low] > array[low+1]){
                swap(array,low,low+1);
                low++;
            }else{
                swap(array,low+1,high);
                high--;
            }
        }
        return low;
    }

}
