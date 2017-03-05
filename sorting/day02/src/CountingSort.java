public class CountingSort {

    /**
     * Use counting sort to sort positive integer array A.
     * Runtime: N + K
     */
    static void countingSort(int[] A) {
        int max = A[0];
        int min = A[0];
        for(int i : A){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }
        int[] counts = new int[max-min + 1];
        for(int i : A){
            counts[i - min]++;
        }
        int i = 0;
        int k = 0;
        while(i < counts.length){
            if(counts[i] != 0){
                counts[i]--;
                A[k] = i+min;
                k++;
            }else{
                i++;
            }
        }

    }

}
