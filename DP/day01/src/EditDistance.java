import java.util.Arrays;

public class EditDistance {
    public static int minEditDist(String a, String b) {
        int[][] checked = new int[a.length()+1][b.length()+1];
        for(int i = 0; i < checked.length;i++){
            for(int j = 0; j < checked[0].length;j++){
                checked[i][j] = 0;
            }
        }
        return minEditDistR(a.toCharArray(),b.toCharArray(),checked);
    }

    public static int minEditDistR(char[] a, char[] b, int[][] checked) {

        char[] a1 = a;
        char[] b1 = b;
        if(checked[a.length][b.length] != 0){
            return checked[a.length][b.length];
        }
        if(a1.length == 0){
            return b1.length;
        }else if(b1.length == 0){
            return a1.length;
        }

        if(a1[a1.length-1] == b1[b1.length-1]){
            char[] newA = Arrays.copyOfRange(a1, 0, a1.length-1);
            char[] newB = Arrays.copyOfRange(b1, 0, b1.length-1);
            checked[a.length][b.length] = minEditDistR(newA, newB,checked);
            return checked[a.length][b.length];
        }else{
            char[] newA = Arrays.copyOfRange(a1, 0, a1.length-1);
            char[] newB = Arrays.copyOfRange(b1, 0, b1.length-1);
            int min =  minEditDistR(newA, newB,checked);
            newA = Arrays.copyOfRange(a1, 0, a1.length);
            newB = Arrays.copyOfRange(b1, 0, b1.length-1);
            if(min > minEditDistR(newA, newB,checked)){
                min = minEditDistR(newA, newB,checked);
            }
            newA = Arrays.copyOfRange(a1, 0, a1.length-1);
            newB = Arrays.copyOfRange(b1, 0, b1.length);
            if(min > minEditDistR(newA, newB,checked)){
                min = minEditDistR(newA, newB,checked);
            }
            checked[a.length][b.length] = min +1;
            return min + 1;
        }
    }

}
