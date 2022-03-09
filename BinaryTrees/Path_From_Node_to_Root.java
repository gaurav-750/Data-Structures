package BinaryTrees;

import java.util.*;

public class Path_From_Node_to_Root {

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

    // Path from Node to Root - For a general Binary Search Tree(BST) :
    public static ArrayList<Integer> pathFinderBST(BinaryTreeNode<Integer> root, int k){
        // base case
        if (root == null){
            return null;
        }

        if (root.data == k){
            ArrayList<Integer> output = new ArrayList<>(); // creating a new ArrayList
            output.add(root.data); // appending root's data to list
            return output; // returning list
        }

        ArrayList<Integer> smallOutput; // declaring ArrayList
        if (root.data > k){
            smallOutput = pathFinderBST(root.left, k);
        }else {
            smallOutput = pathFinderBST(root.right, k);
        }
        if (smallOutput != null){
            smallOutput.add(root.data);
            return smallOutput;
        }

        return null;
    }

    // Path from Node to Root - For a general Binary Tree/Binary Search Tree
    public static ArrayList<Integer> pathFinder(BinaryTreeNode<Integer> root, ArrayList<Integer> list, int element){
        // base case
        if (root == null){
            return null;
        }

        if (root.data == element){
            list.add(root.data);
            return list;
        }

        ArrayList<Integer> leftList = pathFinder(root.left, list, element);
        if (leftList != null){
            leftList.add(root.data);
            return leftList;
        }
        ArrayList<Integer> rightList = pathFinder(root.right, list, element);
        if (rightList != null){
            rightList.add(root.data);
            return rightList;
        }

        return null;
    }

    public static ArrayList<Integer> pathFromNodeToRoot(BinaryTreeNode<Integer> root, int k){
        ArrayList<Integer> list = new ArrayList<>();
        return pathFinder(root, list, k);
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

    // Date: 06-10-2021
    // 22:03
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter k: ");
        int k = sc.nextInt();

//        ArrayList<Integer> ans = pathFromNodeToRoot(root, k);
        ArrayList<Integer> ans = pathFinderBST(root, k);
        for (int elem : ans){
            System.out.print(elem + " ");
        }



    }
}
