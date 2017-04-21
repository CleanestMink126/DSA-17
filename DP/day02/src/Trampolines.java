import java.util.ArrayList;
import java.util.Arrays;

public class Trampolines {
    public static int trampoline(int[] nums) {
        return recurseT(nums);
    }
    public static int recurseT(int[] nums){
        if(nums.length == 1){
            return 0;
        }
        for(int i = 0; i < nums.length;i++){

            if(nums[i] >= nums.length-i-1){
                int res = recurseT(Arrays.copyOfRange(nums,0, i+1));
                if(res == -1){
                    return -1;
                }
                return 1 + res;
            }
        }
        return -1;

    }
}