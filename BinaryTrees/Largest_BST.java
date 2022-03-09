package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Date: 08-10-2021
// 18:23
public class Largest_BST {

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

    public static boolean checkIfBST(BinaryTreeNode<Integer> root, int minRange, int maxRange){
        // base case
        if (root == null){
            return true;
        }

        if (root.data < minRange || root.data > maxRange) {
            return false;
        }

        boolean isLeftWithinRange = checkIfBST(root.left, minRange, root.data-1);
        boolean isRightWithinRange = checkIfBST(root.right, root.data, maxRange);

        boolean result = isLeftWithinRange && isRightWithinRange;
        return result;
    }
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

    public static int largestBST(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return 0;
        }

        boolean isBST = checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (isBST){
            return heightOfTree(root);
        }

        int leftLargestBST = largestBST(root.left);
        int rightLargestBST = largestBST(root.right);

        return Math.max(leftLargestBST, rightLargestBST);
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

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

        System.out.println("Height of Largest BST: " + largestBST(root));
    }
}
