import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BarnRepair {
    public static int solve(int M, int S, int C, int[] occupied) {
        ArrayList<gap> gaps= new ArrayList<>();
        int CM = 1;
        Arrays.sort( occupied );
        for(int i = 0; i < occupied.length-1;i++){
            if(occupied[i+1] - occupied[i] > 1) {
                gaps.add(new gap(occupied[i], occupied[i + 1], occupied[i + 1] - occupied[i]));
                CM++;
            }
        }
        while(M < CM){
            gap closed = findMin(gaps);
            gaps.remove(closed);
            C += closed.length - 1;
            CM--;
        }
        System.out.println(C);
        return C;
    }
    public static gap findMin(ArrayList<gap> gaps){
        gap lowest = gaps.get(0);
        for(gap i : gaps){
            if(i.length < lowest.length){
                 lowest = i;
            }
        }
        return lowest;
    }
}
class gap{
    public int start;
    public int end;
    public int length;
    public gap(int start1, int end1, int length1){
        start = start1;
        end = end1;
        length = length1;
    }
}
