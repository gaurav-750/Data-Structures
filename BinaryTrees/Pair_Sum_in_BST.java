package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pair_Sum_in_BST {

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

    public static boolean isNodePresentInBST(BinaryTreeNode<Integer> root, int x){
        // base case
        if (root == null){
            return false;
        }
        if (root.data == x){
            return true;
        }

        boolean output;
        if (x < root.data){
            output = isNodePresentInBST(root.left, x);
        }else {
            output = isNodePresentInBST(root.right, x);
        }

        return output;
    }

    public static boolean checkIFPairExist(ArrayList<Pair<Integer, Integer>> list, int data){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).minimum == data || list.get(i).maximum == data){
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Pair<Integer, Integer>> PairSumInBSTHelper(BinaryTreeNode<Integer> root, int s){
        if (root == null){
            return null;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();

        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.poll();
            if (frontNode.left != null && frontNode.right != null){
                queue.add(frontNode.left);
                queue.add(frontNode.right);
            }else if (frontNode.left != null){
                queue.add(frontNode.left);
            }else if (frontNode.right != null){
                queue.add(frontNode.right);
            }

            if (frontNode.data <= s) {
                int x = s - frontNode.data;
                boolean isPresent = false;

                if (x < frontNode.data) {
                    isPresent = isNodePresentInBST(root.left, x);
                } else if (x > frontNode.data){
                    isPresent = isNodePresentInBST(root.right, x);
                }

                if (isPresent){
                    boolean doesPairAlreadyExist = checkIFPairExist(list, frontNode.data);
                    if (!doesPairAlreadyExist){
                        Pair<Integer, Integer> pairSum;
                        if (frontNode.data < x){
                            pairSum = new Pair<>(frontNode.data, x);
                        }else {
                            pairSum = new Pair<>(x, frontNode.data);
                        }
                        list.add(pairSum);
                    }
                }
            }

        }

        return list;
    }

    public static void pairSumInBST(BinaryTreeNode<Integer> root, int s){
        ArrayList<Pair<Integer, Integer>> list = PairSumInBSTHelper(root, s);

        if (list.size() != 0) {
            for (Pair<Integer, Integer> pair : list) {
                System.out.println(pair.minimum + " " + pair.maximum);
            }
        }
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

    // Date: 08-10-2021
    // 18:45
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter s: ");
        int s = sc.nextInt();

        pairSumInBST(root, s);
    }
}
