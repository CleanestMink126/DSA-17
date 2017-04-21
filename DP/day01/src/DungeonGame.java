import java.util.Arrays;

public class DungeonGame {

    public static int minInitialHealth(int[][] map) {
        int[][] checked = new int[map.length][map[0].length];
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[0].length; j++) {
                checked[i][j] = -1;
            }
        }
        for (int i = checked.length; i >= 0; i--) {
            for (int j = checked[0].length; j >= 0; j--) {
                roomPath(map,i,j,checked);
            }
        }
        return (roomPath(map,0,0,checked) * -1 + 1);
    }
    public static int roomPath(int[][] map, int x, int y, int[][] checked){
        if(x>=map.length || y>=map[0].length){
            return Integer.MIN_VALUE;
        }else if(x == map.length -1 && y == map.length -1) {
            return map[x][y];
        }else if(checked[x][y] != -1){
            return checked[x][y];
        }

        int max =  roomPath(map, x+1, y,checked);
        if(max < roomPath(map, x, y+1,checked)){
            max = roomPath(map, x, y+1,checked);
        }
        if(max>0) {
            max = 0;
        }
        int ans = max + map[x][y];
        if(ans>0){
            ans = 0;
        }
        checked[x][y] = ans;
        return ans;
    }
}
