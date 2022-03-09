package BinaryTrees;
import java.util.Scanner;

public class Remove_Leaf_Nodes {

    public static BinaryTreeNode<Integer> takeInputBTree(boolean isRoot, int parentData, boolean isLeft){
        if (isRoot){
            System.out.print("Enter root data: ");
        }else {
            if (isLeft){
                System.out.print("Enter left child of " + parentData + ": ");
            }else {
                System.out.print("Enter right child of " + parentData + ": ");
            }
        }

        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // create node for root
        BinaryTreeNode<Integer> leftChild = takeInputBTree(false, rootData, true);
        BinaryTreeNode<Integer> rightChild = takeInputBTree(false,rootData, false);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null){
            return null;
        }

        BinaryTreeNode<Integer> leftLeaf = removeLeaves(root.left);
        root.left = leftLeaf;

        BinaryTreeNode<Integer> rightLeaf = removeLeaves(root.right);
        root.right = rightLeaf;

        return root;
    }

    public static void printBinaryTree(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){ // if root is null, simply return as we cannot print root.data
            return;
        }
        System.out.print(root.data + ": ");
        if (root.left != null){
            System.out.print("L" + root.left.data + ", ");
        }
        if (root.right != null){
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printBinaryTree(root.left); // Recursive call on root's left (node)
        printBinaryTree(root.right); // Recursive call on root's right (node)

        return;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputBTree(true, -1, false);
        printBinaryTree(root);

        BinaryTreeNode<Integer> resultNode = removeLeaves(root);
        System.out.println("After removing Leaves: ");
        printBinaryTree(resultNode);
    }
}
