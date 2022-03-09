package BinaryTrees;

import java.util.Scanner;

public class Mirror_Binary_Tree {

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

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

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
    // 22:55
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputBTree(true, -1, false);
        printBinaryTree(root);

        mirrorBinaryTree(root);
        printBinaryTree(root);
    }
}
