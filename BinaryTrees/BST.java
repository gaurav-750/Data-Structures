package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    // data members
    private BinaryTreeNode<Integer> root;
    private int size;

                // member Functions :

    // helper function for isPresent:
    private static boolean searchInBST(BinaryTreeNode<Integer> root, int k){
        // base case
        if (root == null){
            return false;
        }

        if (root.data == k){
            return true;
        }

        if (root.data > k){
            return searchInBST(root.left, k);
        }else {
            return searchInBST(root.right, k);
        }
    }
    public boolean isPresent(int k){
        return searchInBST(root, k);
    }

    // helper function for insert:
    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int x){
        // base case
        if (root == null){ // create a new binary node with data as 'x'
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
            return newRoot;
        }

        if (root.data > x){ // we need to insert on root's left
            root.left = insertHelper(root.left, x);
        }else { // means root.data <= x, we need to insert on root's right
            root.right = insertHelper(root.right, x);
        }

        return root;
    }
    public void insert(int x){
        root = insertHelper(root, x);
        size++;
        return;
    }

    private static int smallestNodeData(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return Integer.MAX_VALUE;
        }
        int smallestLeft = smallestNodeData(root.left);
        int smallestRight = smallestNodeData(root.right);

        int smallest = Math.min(root.data, Math.min(smallestLeft, smallestRight));
        return smallest;
    }

    private static BSTDeleteReturn deleteHelper(BinaryTreeNode<Integer> root, int x){
        // base case
        if (root == null){
            return new BSTDeleteReturn(null, false);
        }

        if (root.data < x){
            BSTDeleteReturn rightOutput = deleteHelper(root.right, x);
            root.right = rightOutput.root;
            rightOutput.root = root;
            return rightOutput;
        }

        if (root.data > x){
            BSTDeleteReturn leftOutput = deleteHelper(root.left, x);
            root.left = leftOutput.root;
            leftOutput.root = root;
            return leftOutput;
        }

        //root.data == x

        // 0 children
        if (root.left == null && root.right == null){
            return new BSTDeleteReturn(null, true);
        }

        //only left child
        if (root.left != null && root.right == null){
            return new BSTDeleteReturn(root.left, true);
        }

        // only right child
        if (root.left == null && root.right != null){
            return new BSTDeleteReturn(root.right, true);
        }

        // both children are present
        int rightMin = smallestNodeData(root.right);
        root.data = rightMin;
        BSTDeleteReturn rightOutput = deleteHelper(root.right, rightMin);
        root.right = rightOutput.root;

        return new BSTDeleteReturn(root, true);
    }

    public boolean delete(int x){
        BSTDeleteReturn output = deleteHelper(root, x);
        root = output.root;
        if (output.deleted){
            size--;
        }

        return output.deleted;
    }

    public int size(){
        return size;
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> root){
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
    public void printTree(){
        printTreeHelper(root);
        return;
    }

}
