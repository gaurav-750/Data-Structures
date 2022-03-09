package BinaryTrees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Construct_BST_Using_Array {

    public static BinaryTreeNode<Integer> constructBST(int[] arr, int si, int ei){
        // base case
        if (si > ei){
            return null;
        }

        int midIndex = (si+ei)/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[midIndex]);
        BinaryTreeNode<Integer> leftNode = constructBST(arr, si, midIndex-1);
        BinaryTreeNode<Integer> rightNode = constructBST(arr, midIndex+1, ei);

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

    public static BinaryTreeNode<Integer> constructBSTUsingArray(int[] arr, int n){
        return constructBST(arr, 0, arr.length-1);
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

    // Date: 04-10-2021
    // 23:09
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        BinaryTreeNode<Integer> root = constructBSTUsingArray(arr, n);
        printLevelWiseBT(root);
    }
}
