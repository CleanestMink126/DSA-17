public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        int back = 0;
        for(int i = 0 ; i < points.length;i++){
            MyHashMap<Integer,Integer> currentMap = new MyHashMap<Integer,Integer>();
            for(int j = 0; j < points.length; j ++){
                currentMap.put(getSquaredDistance(new int[]{points[i][0],points[i][1]}, new int[]{points[j][0],points[j][1]}),currentMap.getOrDefault(getSquaredDistance(new int[]{points[i][0],points[i][1]}, new int[]{points[j][0],points[j][1]}),0)+1);
            }


            for(MyLinearMap<Integer,Integer> linMap : currentMap.maps){
                for(Integer myValue : linMap.values()){
                    if(myValue>1){
                        int tot = 0;
                        for(int j = 1;j <myValue;j++ ){
                            tot += 2 * j;
                        }
                        back += tot;
                    }
                }
            }
        }
        return back;
    }

    private static int getSquaredDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}
