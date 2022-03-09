package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Duplicate_Every_Node {

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

    public static void printLevelWiseBT(BinaryTreeNode<Integer> root){
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

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

    public static BinaryTreeNode<Integer> insertDuplicates(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return null;
        }

        BinaryTreeNode<Integer> leftNode = insertDuplicates(root.left);
        BinaryTreeNode<Integer> rightNode = insertDuplicates(root.right);

        BinaryTreeNode<Integer> duplicateNode = new BinaryTreeNode<>(root.data);
        root.left = duplicateNode;
//        duplicateNode.left = leftNode;

        return root;
    }

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root){
        BinaryTreeNode<Integer> finalRoot = insertDuplicates(root);
        return;
    }

    // Date: 02-10-2021
    // 18:48
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

        System.out.println("After Duplicating: ");

        insertDuplicateNode(root);
        printLevelWiseBT(root);
    }
}
