package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Check_If_BST {

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

    public static int maximum(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return -1;
        }
        int largestLeft = maximum(root.left);
        int largestRight = maximum(root.right);

        int largest = Math.max(root.data, Math.max(largestLeft, largestRight));
        return largest;
    }

    public static int minimum(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return Integer.MAX_VALUE;
        }

        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);

        int minValue = Math.min(root.data, Math.min(leftMin, rightMin));
        return minValue;
    }

    public static boolean checkIfBST(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return true;
        }

        int leftMax = maximum(root.left); // finding maximum from left subTree
        if (leftMax >= root.data){
            return false;
        }
        int rightMin = minimum(root.right); // finding minimum from right subTree
        if (rightMin < root.data){
            return false;
        }

        boolean isLeftBST = checkIfBST(root.left);
        boolean isRightBST = checkIfBST(root.right);

        boolean isBST = isLeftBST && isRightBST;
        return isBST;
    }

    // This is improved solution for checkIfBST.
    // Here, we created a class IsBSTReturn, which gives us min, max and a boolean isBST in one go.
    // so, no need to call other functions, because ISBSTReturn basically gives us all of those values.
    // Time Complexity - O(n)
    public static isBSTReturn checkIFBST_2(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            isBSTReturn ans = new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return ans;
        }

        isBSTReturn leftAns = checkIFBST_2(root.left);
        isBSTReturn rightAns = checkIFBST_2(root.right);

        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
        boolean isBST = true;

        // Now we check those 4 conditions for a tree to be a BST :-
        if (leftAns.max >= root.data){
            isBST = false;
        }
        if (rightAns.min < root.data){
            isBST = false;
        }

        if (!leftAns.isBST){
            isBST = false;
        }
        if (!rightAns.isBST){
            isBST = false;
        }

        isBSTReturn answer = new isBSTReturn(min, max, isBST);
        return answer;
    }

                    // Best Solution 😉
    public static boolean checkIfBST_3(BinaryTreeNode<Integer> root, int minRange, int maxRange){
        // base case
        if (root == null){
            return true;
        }

        if (root.data < minRange || root.data > maxRange) {
            return false;
        }

        boolean isLeftWithinRange = checkIfBST_3(root.left, minRange, root.data-1);
        boolean isRightWithinRange = checkIfBST_3(root.right, root.data, maxRange);

        boolean result = isLeftWithinRange && isRightWithinRange;
        return result;
    }

    // Date: 04-10-2021
    // 23:15
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

//        System.out.println(checkIfBST(root));
        isBSTReturn ans = checkIFBST_2(root);
        System.out.println(ans.min + " " + ans.max + " " + ans.isBST);
    }
}
/*
For a Tree to be a BST, it must satisfy the following conditions:

1. Root has to be Larger (>) than every element on left side.
2. Root has to be smaller than or equal to (<=) every element on right side.
3. Left subTree should be a BST.
4. Right subTree should also be a BST.
 */