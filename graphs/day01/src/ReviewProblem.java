import java.util.LinkedList;

public class ReviewProblem {

    public static int minimumLengthSubArray(int[] A, int desiredSum) {
        int i = 0;
        int sum = 0;
        int ans = A.length + 1;
        LinkedList<Integer> l = new LinkedList<Integer>();
        while(i < A.length){
            l.addLast(A[i]);
            sum += A[i];
            while(sum >= desiredSum){
                if(sum >= desiredSum && l.size() < ans){
                    ans = l.size();
                }
                sum -= l.remove(0);
            }
            i++;
        }
        if(ans == A.length +1){
            return 0;
        }
        return ans;
    }

}
