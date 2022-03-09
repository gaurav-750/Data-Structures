package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test_03 {

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

    public static int depthOfNode(BinaryTreeNode<Integer> root, int p){
        // base case
        if (root == null){
            return -1;
        }

        if (root.data == p){
            return 0;
        }

        int leftDepth = depthOfNode(root.left, p);
        if (leftDepth != -1){
            return leftDepth+1;
        }
        int rightDepth = depthOfNode(root.right, p);
        if (rightDepth != -1){
            return rightDepth+1;
        }

        return -1;
    }

    public static int findParent(BinaryTreeNode<Integer> root, int p){
        // base case
        if (root == null){
            return -1;
        }

        if (root.data == p){
            return -1;
        }

        if (root.left != null){
            if (root.left.data == p){
                return root.data;
            }
        }
        if (root.right != null){
            if (root.right.data == p){
                return root.data;
            }
        }

        int leftAns = findParent(root.left, p);
        if (leftAns != -1){
            return leftAns;
        }
        int rightAns = findParent(root.right, p);
        if (rightAns != -1){
            return rightAns;
        }

        return -1;
    }

    public static boolean checkCousins(BinaryTreeNode<Integer> root, int p, int q){
        int depth_p = depthOfNode(root, p);
        int depth_q = depthOfNode(root, q);
        if (depth_p != depth_q){
            return false;
        }

        int parentOfp = findParent(root, p);
        int parentOfq = findParent(root, q);

        if (parentOfp == parentOfq){
            return false;
        }
        return true;
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

    public static ArrayList<Integer> NodeAtDepthk(BinaryTreeNode<Integer> root, int k, ArrayList<Integer> list){
        if (root == null){
            return null;
        }
        if (k == 0){
            System.out.print(root.data + " ");
            list.add(root.data);
            return list;
        }

        ArrayList<Integer> leftNode = NodeAtDepthk(root.left, k-1, list);
        ArrayList<Integer> rightNode = NodeAtDepthk(root.right, k-1, list);

        return list;
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

    public static ArrayList<Integer> longestPathFromLeafToRoot(BinaryTreeNode<Integer> root){
        int treeHeight = heightOfTree(root);
        ArrayList<Integer> listD = new ArrayList<>();
        ArrayList<Integer> depthList = NodeAtDepthk(root, treeHeight-1, listD);

//        System.out.println(treeHeight + " " + farthestNode);

        int farthestNode = listD.get(listD.size()-1);
        System.out.println("farthestNode = " + farthestNode);
        ArrayList<Integer> list = new ArrayList<>();

        return pathFinder(root, list, farthestNode);
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

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter p: ");
        int p = sc.nextInt();
        System.out.print("Enter q: ");
        int q = sc.nextInt();

        System.out.println(checkCousins(root, p, q)); // problem 01

        ArrayList<Integer> list = longestPathFromLeafToRoot(root);
        System.out.println(list);
    }
}
