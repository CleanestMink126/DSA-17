import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size()/2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size()/2-1))/2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runningMedian = new double[inputStream.length];
        if(inputStream.length < 1){
            return runningMedian;
        }
        int median = inputStream[0];
        runningMedian[0] = median;
        PriorityQueue<Integer> myMin = minPQ();
        PriorityQueue<Integer> myMax = maxPQ();
        for (int i = 1; i < inputStream.length; i++) {
            if(inputStream[i]>median){
                myMin.offer(inputStream[i]);
            }else if(inputStream[i]<median){
                myMax.offer(inputStream[i]);
            }else{
                myMin.offer(inputStream[i]);
            }

            if(myMin.size() > myMax.size() + 1){
                myMax.offer(median);
                median = myMin.poll();
            }else if(myMax.size() > myMin.size() + 1){
                myMin.offer(median);
                median = myMax.poll();
            }

            if(myMax.size() > myMin.size()){
                runningMedian[i] = (median + myMax.peek()) / 2.0;
            }else if(myMin.size() > myMax.size()){
                runningMedian[i] = (median + myMin.peek()) / 2.0;
            }else{
                runningMedian[i]= median;
            }


        }
        return runningMedian;
    }

}
