
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * Best-case runtime:N
     * Worst-case runtime:N^2
     * Average-case runtime:N^2
     *
     * Space-complexity:1
     */
    @Override
    public int[] sort(int[] array) {
        for(int i = 1; i < array.length;i++){
            int j = i;
            while (array[j] <= array[j-1]){
                int ph = array[j-1];
                array[j-1]= array[j];
                array[j]= ph;
                j--;
                if(j == 0){
                    break;
                }
            }
        }
        return array;

    }
}
