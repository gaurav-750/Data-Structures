package BinaryTrees;

import java.util.Scanner;

public class Height_Of_Tree {

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

    public static int heightOfTree(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int height = Math.max(leftHeight, rightHeight);

        return height+1;
    }

    public int getHeight(BinaryTreeNode<Integer> root){
        return heightOfTree(root);
    }

    // Date: 21-09-2021
    // 22:46
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputBTree(true, -1, false);
        printBinaryTree(root);

        System.out.println("height = " + heightOfTree(root));
    }
}
