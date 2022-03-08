package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Replace_Node_With_Depth {

    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        int rootData = sc.nextInt();
        TreeNode<Integer> rootNode = new TreeNode<>(rootData);
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.poll();
            System.out.print("Enter the number of children of " + frontNode.data + ": ");
            int numChildren = sc.nextInt();

            int i = 0;
            while (i < numChildren){
                System.out.print("Enter " + (i+1) + "th child of " + frontNode.data + ": ");
                int child = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(child);
                frontNode.children.add(childNode);
                queue.add(childNode);
                i++;
            }

        }

        return rootNode;
    }
                    // Iterative Approach:
    public static void replaceNodeWithDepth(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int n = 1;
        int tChildNodes = 0;
        int depth = 0;
        while (!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.poll();
            frontNode.data = depth;
            n--;
            tChildNodes = tChildNodes + frontNode.children.size();

            if (n == 0){
                depth = depth+1;
                n = tChildNodes;
                tChildNodes = 0;
            }

            queue.addAll(frontNode.children); // adding all children of frontNode to queue
        }

    }

                    // Recursive Approach:
    public static void replaceNodesWithDepthRecursively(TreeNode<Integer> root, int depth){
        //base case
        if (root == null){
            return;
        }

        root.data = depth;

        for (int i = 0; i < root.children.size(); i++) {
            replaceNodesWithDepthRecursively(root.children.get(i), depth+1);
        }

        return;
    }

    public static void printTree(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        int n = 1, c = 0;
        while (!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.poll();
            System.out.print(frontNode.data + " ");
            n--;
            c = c + frontNode.children.size();

            if (n == 0){
                System.out.println();
                n = c;
                c = 0;
            }
            int i = 0;
            while (i < frontNode.children.size()){
                queue.add(frontNode.children.get(i));
                i++;
            }
        }

    }

    // Date: 20-09-2021
    // 23:00
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
//        replaceNodeWithDepth(root);
        printTree(root);

        System.out.println("Through Recursion: ");
        replaceNodesWithDepthRecursively(root, 0);
        printTree(root);
    }
}
