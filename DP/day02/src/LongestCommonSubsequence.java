import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String S, String T) {
        int[][] checked = new int[S.length()+1][T.length()+1];
        for(int i = 0; i < checked.length;i++){
            for(int j = 0; j < checked[0].length;j++){
                checked[i][j] = -1;
            }
        }
        return minEditDistR(S.toCharArray(),T.toCharArray(),checked);
    }

    public static int minEditDistR(char[] a, char[] b, int[][] checked) {

        char[] a1 = a;
        char[] b1 = b;
        if(checked[a.length][b.length] != -1){
            return checked[a.length][b.length];
        }
        if(a1.length == 0){
            return 0;
        }else if(b1.length == 0){
            return 0;
        }

        if(a1[a1.length-1] == b1[b1.length-1]){
            char[] newA = Arrays.copyOfRange(a1, 0, a1.length-1);
            char[] newB = Arrays.copyOfRange(b1, 0, b1.length-1);
            checked[a.length][b.length] = minEditDistR(newA, newB,checked) + 1;
            return checked[a.length][b.length];
        }else{
            char[] newA = Arrays.copyOfRange(a1, 0, a1.length);
            char[] newB = Arrays.copyOfRange(b1, 0, b1.length-1);
            int max =  minEditDistR(newA, newB,checked);
            newA = Arrays.copyOfRange(a1, 0, a1.length-1);
            newB = Arrays.copyOfRange(b1, 0, b1.length);
            if(max < minEditDistR(newA, newB,checked)){
                max = minEditDistR(newA, newB,checked);
            }
            checked[a.length][b.length] = max;
            return max;
        }
    }

}
