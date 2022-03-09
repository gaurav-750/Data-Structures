package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PathSum_Root_to_Leaf {

    public static BinaryTreeNode<Integer> takeInputLevelWiseBT(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        int rootData = sc.nextInt();
        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.poll();
            System.out.print("Enter left child of " + frontNode.data + ": ");
            int leftChild = sc.nextInt();
            if (leftChild != -1){
                BinaryTreeNode<Integer> leftChildNode = new BinaryTreeNode<>(leftChild);
                frontNode.left = leftChildNode;
                queue.add(leftChildNode);
            }

            System.out.print("Enter right child of " + frontNode.data + ": ");
            int rightChild = sc.nextInt();
            if (rightChild != -1){
                BinaryTreeNode<Integer> rightChildNode = new BinaryTreeNode<>(rightChild);
                frontNode.right = rightChildNode;
                queue.add(rightChildNode);
            }

        }

        return root;
    }

    public static void pathRootToLeaf(BinaryTreeNode<Integer> root, int k, String str){
        if (root == null){
            return;
        }
        str = str + root.data + " ";

        pathRootToLeaf(root.left, k-root.data, str);
        pathRootToLeaf(root.right, k-root.data, str);

        if (k == root.data && root.left == null && root.right == null){
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i) + "");
            }
            System.out.println();
        }

        return;
    }

    public static void pathSumRootToLeaf(BinaryTreeNode<Integer> root, int k){
        String str = "";
        pathRootToLeaf(root, k, str);
        return;
    }

    public static void printLevelWiseBT(BinaryTreeNode<Integer> root){
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        if (root == null){
            return;
        }

        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.poll();
            System.out.print(frontNode.data + ": ");

            if (frontNode.left != null && frontNode.right != null){
                System.out.print("L" + frontNode.left.data + ", " + "R" + frontNode.right.data);
                queue.add(frontNode.left);
                queue.add(frontNode.right);
            }else if (frontNode.left != null){
                System.out.print("L" + frontNode.left.data);
                queue.add(frontNode.left);
            }else if (frontNode.right != null){
                System.out.print("R" + frontNode.right.data);
                queue.add(frontNode.right);
            }
            System.out.println();
        }

    }

    // Date: 03-10-2021
    // 08:50
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        pathSumRootToLeaf(root, k);

//        String str = "5" + " ";
////        str = str + 6 + " ";
////        str = str + 2 + " ";
////
////        System.out.println(str);
////        for (int i = 0; i < str.length(); i++) {
////            System.out.print(str.charAt(i) + "");
////        }
    }
}

/*
    public static void pathRootToLeaf(BinaryTreeNode<Integer> root, int k, String str, int cs){
        if(root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            cs += root.data; //current sum

            if (cs == k) {
                // System.out.println((str + root.data + " "));
                str = str + root.data + " ";
                for(int i = 0; i < str.length(); i++){
                    System.out.print(str.charAt(i) + "");
                }
                System.out.println();
            }
            return;
        }

        pathRootToLeaf(root.left, k, (str + root.data + " "), (cs + root.data));
        pathRootToLeaf(root.right, k, (str + root.data + " "), (cs + root.data));

        return;
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        String str = "";
        pathRootToLeaf(root, k, str, 0);
        return;
        */