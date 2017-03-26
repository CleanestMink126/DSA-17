import java.util.*;

public class ShortestPath {

    public static List<Integer> shortestPath(Graph g, int v, int w) {
        HashSet<Integer> checked = new HashSet<Integer>();
        LinkedList<TreeNode<Integer>>myQ = new LinkedList<TreeNode<Integer>>();
        myQ.add(new TreeNode<Integer>(v,0));
        while(myQ.size() > 0){
            TreeNode<Integer> place = myQ.remove(0);
            for(int i: g.getNeighbors(place.key)){
                if(!checked.contains(i)) {
                    TreeNode<Integer> temp = new TreeNode<Integer>(i, place.height + 1);
                    temp.leftChild = place;
                    myQ.add(temp);
                    checked.add(i);
                    if(i == w){
                        return findList(temp);
                    }
                }

            }
        }
        return null;


    }

    public static List<Integer> findList(TreeNode<Integer> temp){
        LinkedList<Integer> my = new LinkedList<Integer>();
        while(temp.hasLeftChild()){
            my.addLast(temp.key);
            temp = temp.leftChild;
        }
        my.addLast(temp.key);
        Collections.reverse(my);
        return my;
    }


    public static int distanceBetween(Graph g, int v, int w) {
        List<Integer> my = shortestPath(g,v,w);
        if(my != null){
            return shortestPath(g,v,w).size() - 1;
        }
        return -1;
    }

}