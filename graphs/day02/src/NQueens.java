import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

    public static List<char[][]> nQueensSolutions(int n) {
        ArrayList<char[][]> ans = new ArrayList<char[][]>();
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board.length; j++){
                board[j][i] = '.';
            }
        }
        recurseQ(0,0, n, board, ans);
        for(int i = 0; i < ans.size(); i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    System.out.print(ans.get(i)[j][k]);
                }
                System.out.println(' ');
            }
            System.out.println("-----------------");
        }
        return ans;
    }

    public static void recurseQ(int x, int y, int n, char[][] board, List<char[][]> ans){

        if(isValid(x,y,board)){
            board[x][y] = 'Q';
            if(n == 1){
                ans.add(copyOf(board));
            }
            if(x + 1 == board.length  && y + 1< board.length){
                recurseQ(0, y+1, n-1,board,ans);
            }else if(x + 1 != board.length && y < board.length){
                recurseQ(x+1, y, n-1,board, ans);
            }
        }
        board[x][y] = '.';
        if(x + 1 == board.length && y + 1< board.length){
            recurseQ(0, y+1, n,board, ans);
        }else if(x + 1 != board.length && y< board.length){
            recurseQ(x+1, y, n,board, ans);
        }
    }

    public static boolean isValid(int x, int y,char[][] board){
        for(int i = 0; i < board.length; i ++) {
            if(board[x][i] ==  'Q') {
                return false;
            }
        }
        for(int i = 0; i < board.length; i ++){
            if(board[i][y] ==  'Q'){
                return false;
            }
            if((x-i + y < board[0].length) && (x-i + y >= 0)){
                if(board[i][y+ x - i] ==  'Q'){
                    return false;
                }
            }
            if((i-x + y < board[0].length) && (i-x + y >= 0)){
                if(board[i][y+ i-x] ==  'Q'){
                    return false;
                }
            }
        }
        return true;
    }

}
