package BinaryTrees;

import java.util.Scanner;

public class Nodes_At_Depth_k {

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

    public static void printNodesAtDepthk(BinaryTreeNode<Integer> root, int k){
        if (root == null){
            return;
        }
        if (k == 0){
            System.out.print(root.data + " ");
            return;
        }

        printNodesAtDepthk(root.left, k-1);
        printNodesAtDepthk(root.right, k-1);

        return;
    }

    // Date: 22-09-2021
    // 17:39
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputBTree(true, -1, false);
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        printNodesAtDepthk(root, k);
    }
}
