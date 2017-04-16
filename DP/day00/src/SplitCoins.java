import java.util.ArrayList;
import java.util.HashMap;

public class SplitCoins {
    ArrayList<HashMap<Integer,Integer>> checked;
    int[] coins;
    public static int splitCoins(int[] coins) {
        SplitCoins myCoins = new SplitCoins(coins);
        return myCoins.splitCoins2();

    }

    SplitCoins(int[] coins) {
        this.coins = coins;
        checked = new ArrayList<>();
        for(int i = 0; i < coins.length;i++){
            checked.add(new HashMap<Integer, Integer>());
        }
    }

    public int splitCoins2() {
        return recurseB(coins.length-1, 0);

    }


    public int recurseB(int N, int diff){
        if(N == -1){
            return diff;
        }

        if(checked.get(N).containsKey(diff)){
            return checked.get(N).get(diff);
        }
        int plus = recurseB(N-1, Math.abs(diff + coins[N]));
        int minus = recurseB(N-1, Math.abs(diff - coins[N]));

        int lower;
        if(plus < minus){
            lower = plus;
        }else{
            lower = minus;
        }

        checked.get(N).put(diff, lower);


        return lower;
    }

}
