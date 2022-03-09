package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Print_Nodes_From_TargetNode {

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

    public static void nodesFromTarget(BinaryTreeNode<Integer> root, String str, int node, int k){
        if (root == null){
            return;
        }
        if (k == 0){
            System.out.println(root.data);
        }

        nodesFromTarget(root.left, str, node, k-1);
        nodesFromTarget(root.right, str, node, k-1);

        return;
    }

    public static int depthTargetNode(BinaryTreeNode<Integer> root, int node){
        if (root == null){
            return -1;
        }
        if (root.data == node){
            return 0;
        }

        int depth = depthTargetNode(root.left, node);
        if (depth != -1){
            return depth+1;
        }
        int depth2 = depthTargetNode(root.right, node);
        if (depth2 != -1){
            return depth2+1;
        }

        return -1;
    }

    public static void nodesFromTargetUpper(BinaryTreeNode<Integer> root, int node, int depth, int k){
        if (root == null){
            return;
        }

        if (depth == k){
            System.out.println(root.data);
        }

        nodesFromTargetUpper(root.left, node, depth-1, k); // calling left subtree
        nodesFromTargetUpper(root.right, node, depth-1, k); // calling right subtree

        return;
    }

    public static void printNodesFromTarget(BinaryTreeNode<Integer> root, int node, int k){
        if (root == null){
            return;
        }

        int depth = depthTargetNode(root, node);
        nodesFromTargetUpper(root, node, depth, k);

        if (root.data == node){
            String str = "";
            nodesFromTarget(root, str, node, k);
        }


        printNodesFromTarget(root.left, node, k);
        printNodesFromTarget(root.right, node, k);

        return;
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

    public static void trialTarget(BinaryTreeNode<Integer> root, int node, int k){


    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target node: ");
        int node = sc.nextInt();
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        printNodesFromTarget(root, node, k);
    }
}
