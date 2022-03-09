package BinaryTrees;
import java.util.ArrayList;

public class LongestLeafToRootPath {

    public static int heightOfTree(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int smallHeight = Math.max(leftHeight, rightHeight);

        return smallHeight+1;
    }
    public int getHeight(BinaryTreeNode<Integer> root){
        return heightOfTree(root);
    }
    public static ArrayList<Integer> longestLeafRootPath(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return null;
        }

        // if root is a LeafNode:
        if (root.left == null && root.right == null){
            ArrayList<Integer> list = new ArrayList<>(); // creating a new ArrayList
            list.add(root.data); // adding root to it
            return list;
        }

        Height_Of_Tree h = new Height_Of_Tree();
        int leftHeight = h.getHeight(root.left);
        int rightHeight = h.getHeight(root.right);

        ArrayList<Integer> smallOutput;
        if (leftHeight > rightHeight){
            smallOutput = longestLeafRootPath(root.left);
        }else {
            smallOutput = longestLeafRootPath(root.right);
        }
        smallOutput.add(root.data);

        return smallOutput;
    }

    // Date: 18-12-2021
    public static void main(String[] args) {
        Take_Input_LevelWise_BT input = new Take_Input_LevelWise_BT();
        BinaryTreeNode<Integer> root = input.getInput();
        input.printBTree(root);

        System.out.println(longestLeafRootPath(root));

    }

}
