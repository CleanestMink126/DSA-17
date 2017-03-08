import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        values = (ArrayList<Integer>)(values);
        values.sort(Integer::compareTo);
        System.out.println(values);
        BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();
        addMid(values, myTree);
        return myTree;
    }

    public static void addMid(List<Integer> values, BinarySearchTree<Integer> myTree){
        if(values.size() <= 1){
            myTree.add(values.get(0));
        }else{
            myTree.add(values.get(values.size()/2));
            addMid(values.subList(0,values.size()/2), myTree);
            if(values.size() > 2){
                addMid(values.subList(values.size()/2+ 1, values.size()), myTree);
            }

        }

    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        if(n1.isLeaf() != n2.isLeaf()){
            return false;
        }else if(n1.isLeaf() == true && n2.isLeaf() == true){
            return true;
        }
        if(oneBranch(n1) && oneBranch(n2)){
            if(nodeVal(n1).key.equals(nodeVal(n2).key)){
                return isIsomorphic(nodeVal(n1),nodeVal(n2));
            }
        }
        if(!oneBranch(n1) && !oneBranch(n2)){
            if(n1.hasLeftChild() && n2.hasLeftChild() && n1.leftChild.key.equals(n2.leftChild.key)){
                if(n1.hasRightChild() && n2.hasRightChild() && n1.rightChild.key.equals(n2.rightChild.key)) {
                    return isIsomorphic(n1.leftChild, n2.leftChild) && isIsomorphic(n1.rightChild, n2.rightChild);
                }
            }
            if(n1.hasLeftChild() && n2.hasRightChild() && n1.leftChild.key.equals(n2.rightChild.key)){
                if(n1.hasRightChild() && n2.hasLeftChild() && n1.rightChild.key.equals(n2.leftChild.key)) {
                    return isIsomorphic(n1.leftChild, n2.rightChild) && isIsomorphic(n1.rightChild, n2.leftChild);
                }
            }


        }
        return false;
    }

    public static boolean oneBranch(TreeNode n1){
        return (n1.hasLeftChild() != n1.hasRightChild());
    }

    public static TreeNode nodeVal(TreeNode n1){
        if(n1.hasLeftChild())return n1.leftChild;
        if(n1.hasRightChild())return n1.rightChild;
        return n1;
    }
}
