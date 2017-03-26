import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<Integer> levelOrderTraversal(TreeNode<Integer> n) {
        LinkedList<Integer> ans = new LinkedList<Integer>();
        LinkedList<TreeNode<Integer>>myQ = new LinkedList<TreeNode<Integer>>();
        myQ.add(n);
        while(myQ.size() > 0){
            TreeNode<Integer> place = myQ.remove(0);
            ans.addLast(place.key);
            if(place.hasLeftChild()) {
                myQ.add(place.leftChild);
            }
            if(place.hasRightChild()) {
                myQ.add(place.rightChild);
            }

        }
        return ans;
    }
}
