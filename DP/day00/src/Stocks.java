import java.util.HashMap;

public class Stocks {
    HashMap<Integer, Integer> pointers;
    public int maxProfit(int[] prices) {
        pointers = new HashMap<>();
        int pointer;
        int max = 0;
        pointers.put(prices.length-1, prices.length-1);
        for(int i = prices.length-2; i >= 0; i--){
            pointer = pointers.get(i+1);
            if(prices[i+1] > prices[i] || prices[i] < prices[pointer]){
                pointers.put(i, pointer);
                if(prices[pointer] - prices[i] > max){
                    max = prices[pointer] - prices[i];
                }
            }else{
                pointers.put(i, i);
            }
        }
        return max;
    }

    public int maxProfitWithK(int[] prices, int k) {
        // TODO: Optional
        return -1;
    }

}
