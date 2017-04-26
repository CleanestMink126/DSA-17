import java.util.ArrayList;
import java.util.Arrays;

public class Trampolines {
    public static int trampoline(int[] nums) {
        return recurseT(nums);
    }
    public static int recurseT(int[] nums){
//        if(nums.length == 1){
//            return 0;
//        }
//        for(int i = 0; i < nums.length;i++){
//
//            if(nums[i] >= nums.length-i-1){
//                int res = recurseT(Arrays.copyOfRange(nums,0, i+1));
//                if(res == -1){
//                    return -1;
//                }
//                return 1 + res;
//            }
//        }
//        return -1;
        int[] checked = new int[nums.length];
        for(int i = 0; i < checked.length;i++){
            checked[i] = -1;
        }
        return recurseT2(nums, 0,checked);

    }
    public static int recurseT2(int[] nums, int place, int[] checked){
        if(checked[place] != -1){
            return checked[place];
        }else if(place >= nums.length || nums[place] == 0){
            return Integer.MAX_VALUE;
        }else if(place == nums.length-1){
            return 0;
        }
        int min = recurseT2(nums, place+1,checked);
        for(int j = 1; j <= nums[place];j++){
            if(place + j == nums.length-1){
                checked[place] = 1;
                return checked[place];
            }
            if(min > recurseT2(nums,place+j,checked)){
                min = recurseT2(nums,place+j,checked);
            }
        }
        checked[place] = min + 1;
        return checked[place];

    }
}
