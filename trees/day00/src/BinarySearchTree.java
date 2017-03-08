import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;
    private int size;

    public int size() {
        return size;
    }

    public boolean contains(T key) {
        return find(root, key) != null;
    }

    /**
     * Add a node to the BST. Internally calls insert to recursively find the new node's place
     */
    public boolean add(T key) {
        if (find(root, key) != null) return false;
        root = insert(root, key);
        size++;
        return true;
    }

    public void addAll(T[] keys) {
        for (T k : keys)
            add(k);
    }

    public List<T> inOrderTraversal() {
        ArrayList<T> order = new ArrayList<T>();
        if(size == 0){
            return order;
        }
        TreeNode<T> place = root;
        while(place.hasLeftChild()){
            place = place.leftChild;
        }

        for(int i = 0; i < size; i++){
            order.add(place.key);
            System.out.print(place);
            System.out.print(", ");
            place = findSuccessor(place);

        }
        System.out.println("");
        return order;
    }


    /**
     * Deletes a node from the BST using the following logic:
     * 1. If the node has a left child, replace it with its predecessor
     * 2. Else if it has a right child, replace it with its successor
     * 3. If it has no children, simply its parent's pointer to it
     */
    public boolean delete(T key) {
        TreeNode<T> toDelete = find(root, key);
        if (toDelete == null) {
            System.out.println("Key does not exist");
            return false;
        }
        delete(toDelete);
        size--;
        return true;
    }

    private TreeNode<T> delete(TreeNode<T> n) {
        // Recursive base case
        if (n == null) return null;
        System.out.print("Delete: ");
        System.out.println(n);
        TreeNode<T> replacement;

        if (n.isLeaf()) {
            // Case 1: no children
            replacement = null;
            if(n == root){
                root = replacement;
                System.out.println("This shouldnt run");
                // Put the replacement in its correct place, and set the parent.
            }else{
                n.replaceWith(replacement);
            }


        }else if(n.hasRightChild() != n.hasLeftChild()) {
            // Case 2: one child
            replacement = (n.hasRightChild()) ? n.rightChild : n.leftChild;
            if(n ==root){
                n.key = replacement.key;
                delete(replacement);
                // Put the replacement in its correct place, and set the parent.
            }else{
                n.replaceWith(replacement);
            }
            // replacement is the non-null child

        }else{
            // Case 3: two children
            // TODO
            replacement = findSuccessor(n);
            n.key = replacement.key;
            delete(replacement);

        }
        System.out.print("Root: ");
        System.out.println(root);


        return n;
    }

    public T findPredecessor(T key) {
        TreeNode<T> n = find(root, key);
        if (n != null) {
            TreeNode<T> predecessor = findPredecessor(n);
            if (predecessor != null)
                return predecessor.key;
        }
        return null;
    }

    public T findSuccessor(T key) {
        TreeNode<T> n = find(root, key);
        if (n != null) {
            TreeNode<T> successor = findSuccessor(n);
            if (successor != null)
                return successor.key;
        }
        return null;
    }

    private TreeNode<T> findPredecessor(TreeNode<T> n) {
        if(n.parent == null && !n.hasLeftChild()){
            return null;
        }
        TreeNode<T> place = n;
        if(n.hasLeftChild()){
            place = n.leftChild;
            while(place.hasRightChild()){
                place = place.rightChild;
            }
            return place;
        }else{
            while(place.parent != null){
                if(place.parent.hasRightChild() && place.parent.rightChild.equals(place)){
                    return place.parent;
                }
                place = place.parent;
            }
            return null;
        }
    }

    private TreeNode<T> findSuccessor(TreeNode<T> n) {
        if(n.parent == null && !n.hasRightChild()){
            return null;
        }
        TreeNode<T> place = n;
        if(n.hasRightChild()){
            place = n.rightChild;
            while(place.hasLeftChild()){
                place = place.leftChild;
            }
            return place;
        }else{
            while(place.parent != null){
                if(place.parent.hasLeftChild() && place.parent.leftChild.equals(place)){
                    return place.parent;
                }
                place = place.parent;
            }
            return null;
        }
    }

    /**
     * Returns a node with the given key in the BST, or null if it doesn't exist.
     */
    private TreeNode<T> find(TreeNode<T> currentNode, T key) {
        if (currentNode == null)
            return null;
        int cmp = key.compareTo(currentNode.key);
        if (cmp < 0)
            return find(currentNode.leftChild, key);
        else if (cmp > 0)
            return find(currentNode.rightChild, key);
        return currentNode;
    }

    /**
     * Recursively insert a new node into the BST
     */
    private TreeNode<T> insert(TreeNode<T> node, T key) {
        if (node == null) return new TreeNode<>(key);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftChild = insert(node.leftChild, key);
            node.leftChild.parent = node;
        } else {
            node.rightChild = insert(node.rightChild, key);
            node.rightChild.parent = node;
        }
        return node;
    }
}
