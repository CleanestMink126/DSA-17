import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     *
     * Best-case runtime:NlogN
     * Worst-case runtime:NlogN
     * Average-case runtime:NlogN
     *
     * Space-complexity:N
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        if(array.length <= 1){
            return array;
        }else{
            int[] left = sort(Arrays.copyOfRange(array,0,array.length/2));
            int[] right = sort(Arrays.copyOfRange(array, array.length/2 , array.length));
            return merge(left, right);
        }
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     */
    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int j = 0;
        int k = 0;
        for(int i = 0; i < result.length;i++){
            if(j < a.length && k < b.length){
                if(a[j]<=b[k]){
                    result[i] = a[j];
                    j++;
                }else{
                    result[i] = b[k];
                    k++;
                }
            }else if(j < a.length && k >= b.length){
                result[i] = a[j];
                j++;
            }else if(j >= a.length && k < b.length){
                result[i] = b[k];
                k++;
            }else{
                System.out.println("Uh oh");
            }
        }
        return result;
    }

}
