package BinaryTrees;

import java.util.*;

public class LCA_of_BST {

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

    public static ArrayList<Integer> pathFinder(BinaryTreeNode<Integer> root,ArrayList<Integer> list, int element){
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

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b){
        // first we find the path from root to both a and b. We'll use ArrayList to store paths.
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> pathA = pathFinder(root, list1, a);
        System.out.println(pathA);

        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> pathB = pathFinder(root, list2, b);
        System.out.println(pathB);

        // Now we'll find the number which is present in 'both' the paths and also closest to nodes, i.e farthest from the root
        int i = 0;
        while (i < pathA.size()){
            int j = 0;
            while (j < pathB.size()){
                if (Objects.equals(pathA.get(i), pathB.get(j))){
                    return pathA.get(i);
                }
                j++;
            }

            i++;
        }

        return -1;
    }
                        // OPTIMIZED CODE:
    public static BinaryTreeNode<Integer> getLCANode(BinaryTreeNode<Integer> root, int a, int b){
        // base case
        if (root == null || root.data == a || root.data == b){
            return root;
        }

        if (root.data > a && root.data > b){
            return getLCANode(root.left, a, b);
        }else if (root.data < a && root.data < b){
            return getLCANode(root.right, a, b);
        }

        BinaryTreeNode<Integer> leftLCA = getLCANode(root.left, a, b);
        BinaryTreeNode<Integer> rightLCA = getLCANode(root.right, a, b);

        if (leftLCA != null && rightLCA != null){
            return root;
        }else if (leftLCA != null){
            return leftLCA;
        }

        return rightLCA;
    }

    public static int getLCAOptimized(BinaryTreeNode<Integer> root, int a, int b){
        BinaryTreeNode<Integer> lcaNode = getLCANode(root, a, b);
        return lcaNode.data;
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

    // Date: 05-10-2021
    // 21:46
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.println(getLCA(root, a, b));
        System.out.println(getLCAOptimized(root, a, b));
    }
}
/*
    LCA - Lowest Common Ancestor
    The LCA of two nodes 'A' and 'B' is the shared ancestor of A and B located farthest from the root
    (in some cases, the root itself)
 */
