package BinaryTrees;

public class Number_Of_Nodes {

    public static int numberOfNodes(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return 0;
        }

        int leftNodeCount = numberOfNodes(root.left);
        int rightNodeCount = numberOfNodes(root.right);

        int numNodes = leftNodeCount+rightNodeCount+1;

        return numNodes;
    }

    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = t
    }
}
