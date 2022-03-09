package BinaryTrees;
import java.util.Scanner;

public class Tree_Traversals_in_BTree {

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

    public static void preOrderPrintBT(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){ // if node has no children, just print and return
            System.out.print(root.data + " ");
            return;
        }
        System.out.print(root.data + " ");

        preOrderPrintBT(root.left);
        preOrderPrintBT(root.right);

        return;
    }

    public static void postOrderPrintBT(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){ // if node has no children, just print and return
            System.out.print(root.data + " ");
            return;
        }

        postOrderPrintBT(root.left);
        postOrderPrintBT(root.right);

        System.out.print(root.data + " ");

        return;
    }

    public static void inOrderPrintBT(BinaryTreeNode<Integer> root){
        // base case
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null){
            System.out.print(root.data + " ");
            return;
        }

        inOrderPrintBT(root.left);
        System.out.print(root.data + " ");
        inOrderPrintBT(root.right);

        return;
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

        System.out.println("Pre Order: ");
        preOrderPrintBT(root);
        System.out.println();

        System.out.println("Post Order: ");
        postOrderPrintBT(root);
        System.out.println();

        System.out.println("Inorder: ");
        inOrderPrintBT(root);
    }
}
