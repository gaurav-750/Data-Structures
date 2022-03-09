package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintNodesAtDistanceKFromTarget {

    public static BinaryTreeNode<Integer> takeInputLevelWiseBT(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        int rootData = sc.nextInt();
        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root); // pushing it into queue

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

    public static void printFromTarget(BinaryTreeNode<Integer> root, int k, int targetNode){
        // base case
        if (root == null){
            return;
        }
        if (k == 0 && root.data != targetNode){
            System.out.print(root.data + " ");
            return;
        }

        printFromTarget(root.left, k-1, targetNode);
        printFromTarget(root.right, k-1, targetNode);

        return;
    }

    public static int disRootTargetNode(BinaryTreeNode<Integer> root, int targetNode){
        // base case
        if (root == null){
            return -1;
        }
        if (root.data == targetNode){
            return 0;
        }

        int leftDistance = disRootTargetNode(root.left, targetNode);
        if (leftDistance != -1){
            return leftDistance+1;
        }

        int rightDistance = disRootTargetNode(root.right, targetNode);
        if (rightDistance != -1){
            return rightDistance+1;
        }

        return -1;
    }

    public static void printNodesFromTarget(BinaryTreeNode<Integer> root, int targetNode, int k){

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        if (root.data == targetNode){
            printFromTarget(root, k, targetNode);
            return;
        }

        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> currentNode = queue.poll();
            if (currentNode.data == targetNode){
                printFromTarget(currentNode, k, targetNode);
                int disRootTarget = disRootTargetNode(root, targetNode);
                if (disRootTarget != -1){
                    printFromTarget(root, Math.abs(k-disRootTarget), targetNode);
                    return;
                }

                return;
            }

            if (currentNode.left != null && currentNode.right != null){
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }else if (currentNode.left != null){
                queue.add(currentNode.left);
            }else if (currentNode.right != null){
                queue.add(currentNode.right);
            }

        }

        return;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Target Node's data: ");
        int targetNode = sc.nextInt();
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        printNodesFromTarget(root, targetNode, k);

    }
}
