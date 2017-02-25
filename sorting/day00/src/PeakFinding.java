import java.util.Arrays;

/**
 * Created by sidd on 2/20/17.
 */
public class PeakFinding {

    public static int findOneDPeak(int[] nums){
    	// TODO
        if(nums[0]>=nums[1]){
            return 0;
        }else if(nums[nums.length-1]>=nums[nums.length-2]){
            return nums.length-1;
        }
        return repeak(nums);
    }
    public static int repeak(int[] nums){
        int place = nums.length/2;
        if(nums[place]>=nums[place-1] && nums[place]>=nums[place+1]){
            return place;
        }else if(nums[place]<nums[place-1] && nums[place]>=nums[place+1]){
            return place + repeak(Arrays.copyOfRange(nums,place+1,nums.length));
        }else if(nums[place]>=nums[place-1] && nums[place]<nums[place+1]){
            return repeak(Arrays.copyOfRange(nums,0,place));
        }else{
            return repeak(Arrays.copyOfRange(nums,0,place));
        }
    }


    public static int[] findTwoDPeak(int[][] nums){
    	int j = nums[0].length/2;
    	int k = nums.length/2;
    	int[] thing = iterate(nums,j,k);
        System.out.println( thing[0]);
        System.out.println( thing[1]);
        if(nums[nums.length-1][nums[0].length-1]>= nums[nums.length-2][nums[0].length-1] && nums[nums.length-1][nums[0].length-1]>= nums[nums.length-1][nums[0].length-2] ){
            return new int[]{nums.length-1,nums[0].length-1};
        }
        if(nums[0][0]>=nums[0][1] && nums[0][0]>=nums[1][0]){
            return new int[]{0,0};
        }

        return thing;


    }
    public static int[] iterate(int[][] nums, int j , int k){
        if(j == 0){
            return new int[]{0,findMax(nums[j])};
        }else if(j >= nums.length || k >= nums[0].length){
//            System.out.println(j);
//            System.out.println(k);
//            System.out.println(nums.length);
//            System.out.println(nums[0].length);
//            return new int[]{0,findMax(nums[j])};
            j = j/2;
            k = k/2;
        }
        int max = findMax(nums[j]);
        if(nums[j][max] >= nums[j-1][max] && nums[j][max] >= nums[j+1][max]){
            return new int[]{j,max};
        }else if(nums[j][max] < nums[j-1][max]){

            int[] colArray = new int[j];
            for(int row = 0; row < j; row++)
            {
                colArray[row] = nums[row][k];
            }
            int max2 = findMax(colArray);

            if(nums[max2][k] >= nums[max2][k-1] && nums[max2][k] >= nums[max2][k+1]) {
                return new int[]{max2, k};
            }else if(nums[max2][k] < nums[max2][k-1]){
                int[] ans = iterate(copyArray2d(nums,0,j,0,k),j/2,k/2);
                return ans;
            }else if(nums[max2][k] < nums[max2][k+1]){
                int[] ans = iterate(copyArray2d(nums,0,j,k+1,nums[0].length),j/2,k/2);
                ans[1] += k;
                return ans;
            }


        }else if(nums[j][max] < nums[j+1][max]){

            int[] colArray = new int[j];
            for(int row = j+1; row < nums.length; row++)
            {
                colArray[row- j - 1] = nums[row][k];
            }
            int max2 = findMax(colArray);
            max2 += j + 1;

            if(nums[max2][k] >= nums[max2][k-1] && nums[max2][k] >= nums[max2][k+1]) {
                return new int[]{max2, k};
            }else if(nums[max2][k] < nums[max2][k-1]){
                int[] ans = iterate(copyArray2d(nums,j+1,nums.length,0,k),j/2,k/2 );
                ans[0] += j;
                return ans;
            }else if(nums[max2][k] < nums[max2][k+1]){
                int[] ans = iterate(copyArray2d(nums,j+1,nums.length,k+1,nums[0].length),j/2,k/2 );
                ans[0] += j;
                ans[1] += k;
                return ans;
            }

        }
        return null;

    }
    public static int[][] copyArray2d(int[][] matrix,int j,int j1, int k, int k1){
        int [][] myInt = new int[k1-k][];
        for(int i = k; i < k1; i++)
        {
            int[] aMatrix = matrix[i];
            myInt[i-k] = Arrays.copyOfRange(aMatrix,j,j1);
        }
        return myInt;


    }

    public static int findMax(int[] myArray){
        int max = myArray[0];
        int index = 0;
        for(int i = 1; i < myArray.length;i++){
            if(myArray[i]> max){
                max = myArray[i];
                index = i;
            }
        }
        return index;
    }


}
