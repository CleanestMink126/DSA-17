import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TextJustification {

    public static List<Integer> justifyText(String[] w, int m) {
        ArrayList<Integer> ans = recurseT(w,0,new HashMap<Integer, ArrayList<Integer>>(),m);
        ans.remove(0);
        Collections.reverse(ans);
        return ans;
    }
    public static ArrayList<Integer> recurseT(String[] w, int place,HashMap<Integer, ArrayList<Integer>> myMap, int m){
        if(myMap.containsKey(place)){
            return myMap.get(place);
        }
        if(place >= w.length - 1){
            ArrayList<Integer> pc = new ArrayList<>();
            pc.add(0);
            pc.add(place);
//            myMap.put(place, pc);
            return pc;
        }
        ArrayList<Integer> min = (ArrayList<Integer>) recurseT(w,place + 1,myMap,m).clone();
        int minInt = cost(w,place,place + 1,m) + min.get(0);
//        System.out.println(place);
//        System.out.println(place +1);
//        System.out.println(min.get(0));
//        System.out.println(cost(w,place,place+1,m));
//        System.out.println("-----");
        for(int i = place + 2; i < Integer.min(place + m, w.length); i++){
            ArrayList<Integer> current = recurseT(w,i,myMap,m);
            int cCost = cost(w,place,i,m) + current.get(0);
            if(cCost >-1 && cCost < minInt){
//                System.out.println(cCost);
                min = (ArrayList<Integer>) current.clone();
                minInt = cCost;


            }
//            System.out.println(i);
//            System.out.println(current.get(0));
//            System.out.println(cost(w,place,i,m));
//            System.out.println("-----");
        }
//        System.out.println(place);
//        for(int i = 0; i < min.size();i++){
//            System.out.println(min.get(i));
//        }
//        System.out.println("------");
        min.set(0, minInt);
        min.add(place);
        myMap.put(place, min);
        return min;
    }
    public static int cost(String[] w, int place, int newPlace, int m){
        int tot = 0;
        for(int i = place; i < newPlace; i++){
            tot += w[i].length();
            tot++;
        }
        tot--;
        if(tot > m){
            return Integer.MAX_VALUE;
        }
//        System.out.println(place);
//        System.out.println(newPlace);
//        System.out.println(tot);
//        System.out.println("-----------");
        return (int)Math.pow(m - tot,3);
    }

}