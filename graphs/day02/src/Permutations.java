import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<Integer> A2 = new LinkedList<Integer>();
        A2.addAll(A);
        recurseP(A2, new LinkedList<Integer>(), ans);
        System.out.println(ans);
        return ans;
    }

    public static void recurseP(LinkedList<Integer> A, LinkedList<Integer> B, List<List<Integer>> C){
        if(A.size()>0){
            for(int i = 0; i < A.size(); i ++){
                int temp = A.get(0);
                B.addLast(temp);
                A.remove(0);
                recurseP(A,B,C);
                A.addLast(temp);
                B.removeLast();
            }
        }else{
            System.out.println(B);
            LinkedList<Integer> Ex = new LinkedList<Integer>();
            Ex.addAll(B);
            C.add(Ex);
        }
    }

}
