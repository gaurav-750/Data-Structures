package BinaryTrees;

import java.util.*;

public class Replace_Node_With_Depth {

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

    public static void replaceNodeWithDepth(BinaryTreeNode<Integer> root){
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        int n = 1; int c = 0; int depth = 0;
        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.poll();

            if (frontNode.left != null && frontNode.right != null){
                c = c+2;
            }else if (frontNode.left == null && frontNode.right!= null){
                c = c+1;
            }else if (frontNode.left != null && frontNode.right == null){
                c = c+1;
            }

            frontNode.data = depth;
            n--;
            if (n == 0){
                n = c;
                c = 0;
                depth++;
            }

            if (frontNode.left != null && frontNode.right != null){
               queue.add(frontNode.left);
               queue.add(frontNode.right);
            }else if (frontNode.left != null){
                queue.add(frontNode.left);
            }else if (frontNode.right != null){
                queue.add(frontNode.right);
            }

        }

    }

                    // Recursive approach :- best way to do this problem
    public static void replaceNodeWithDepthRecursively(BinaryTreeNode<Integer> root, int level){
        if (root == null){
            return;
        }
        root.data = level;

        replaceNodeWithDepthRecursively(root.left, level+1);
        replaceNodeWithDepthRecursively(root.right, level+1);

        return;
    }

    public static void printBinaryTree(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){ // if root is null, simply return as we cannot print root.data
            return;
        }
        System.out.print(root.data + ": ");
        if (root.left != null){
            System.out.print("L" + root.left.data + ", ");
        }
        if (root.right != null){
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printBinaryTree(root.left); // Recursive call on root's left (node)
        printBinaryTree(root.right); // Recursive call on root's right (node)

        return;
    }

    // Date: 22-09-2021
    // 18:49
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputBTree(true, -1, false);

        printBinaryTree(root);
//        replaceNodeWithDepth(root);
//        System.out.println("After altering nodes with depth: ");
//        printBinaryTree(root);

        System.out.println("After altering nodes with depth RECURSIVELY:");
        replaceNodeWithDepthRecursively(root, 0);
        printBinaryTree(root);
    }
}
