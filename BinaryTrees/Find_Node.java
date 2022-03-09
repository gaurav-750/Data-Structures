package BinaryTrees;
import java.util.Scanner;

public class Find_Node {

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

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x){
        // base case
        if (root == null){
            return false;
        }
        if (root.data == x){
            return true;
        }

        boolean output = isNodePresent(root.left, x);
        if (output == true){
            return true;
        }else {
            output =  isNodePresent(root.right, x);
        }

        return output;
    }

    public static String numOfChildren(BinaryTreeNode<Integer> root){
        if (root.left != null && root.right != null){ // that means root has 2 children
            return "2";
        }else if (root.left != null){ // root has 1 children in left
            return "1l";
        }else if (root.right != null){ // root has 1 children in right
            return "1r";
        }

        return "0";
    }

    public static void nodeWithoutAnySibling(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return;
        }
        String numChildren = numOfChildren(root);
        if (numChildren == "1l"){
            System.out.print(root.left.data + " ");
        }else if (numChildren == "1r"){
            System.out.print(root.right.data + " ");
        }

        nodeWithoutAnySibling(root.left);
        nodeWithoutAnySibling(root.right);

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

    // Date: 22-09-2021
    // 20:07
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputBTree(true, -1, false);
        printBinaryTree(root);

        System.out.print("Enter node to find: ");
        int x = sc.nextInt();
        System.out.println(isNodePresent(root, x)); // problem 1

        nodeWithoutAnySibling(root); // problem 02
    }
}
