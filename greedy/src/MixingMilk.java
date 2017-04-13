
public class MixingMilk {
    public static int solve(int M, int N, int[] price, int[] units) {
        int munmuns = 0;
        if(units.length<=0){
            return 0;
        }
        int max = findMax(price);

        while(M > 0){
            int minInt = findMin(price);
            if(units[minInt] < M){
                M -= units[minInt];
                munmuns += units[minInt]*price[minInt];
            }else{
                System.out.println(M);
                System.out.println(price[minInt]);
//                System.out.println(munmuns);
                munmuns += (M * price[minInt]);
                System.out.println(munmuns);
                System.out.println("early");
                return munmuns;
            }
            units[minInt] = 0;
            price[minInt] = max + 100;
        }
        System.out.println(munmuns);
        return munmuns;
    }
    public static int findMin(int[] arr){
        int minInt = 0;
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
                minInt= i;
            }
        }
        return minInt;
    }
    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
