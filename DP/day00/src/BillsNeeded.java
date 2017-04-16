import java.util.HashMap;
import java.util.HashSet;

public class BillsNeeded {
    HashMap<Integer, Integer> checked;
    int[] billDenominations;
    public int billsNeeded(int N, int[] billDenominations) {
        checked = new HashMap<>();
        this.billDenominations = billDenominations;
        return recurseB(N) - 1;

    }

    public int recurseB(int N){
        if(N == 0){
            return 1;
        }else if(N < 0){
            return -1;
        }

        if(checked.containsKey(N)){
            return checked.get(N);
        }
        int min = -1;
        for(int i = 0; i < billDenominations.length; i++){
            int l = recurseB(N - billDenominations[i]);
            if(l != -1 ){
                if(min == -1){
                    min = l;
                }else if(l < min){
                    min = l;
                }
            }
        }
        if(min == -1){
            checked.put(N, min);
        }else {
            checked.put(N, min + 1);
        }
        return min + 1;
    }

}
