package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RemoveLeafNodes {

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

    public static TreeNode<Integer> removeLeafNodesFromGenericTree(TreeNode<Integer> root){
        // base case
        if (root == null){
            return null;
        }

        // if the root is leafNode, return null
        if (root.children.size() == 0){
            return null;
        }

        int i = 0;
        while (i < root.children.size()){
            TreeNode<Integer> smallAns = removeLeafNodesFromGenericTree(root.children.get(i));
            if (smallAns == null){ // if the smallAns is a Leaf Node
                root.children.remove(i);
            }else {
                i++;
            }

        }

        return root;
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

    // Date: 18-12-2021
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        printTree(root);

        //Removing Leaf Nodes from a Generic Tree:
        TreeNode<Integer> ansNode = removeLeafNodesFromGenericTree(root);

        System.out.println("After removing Leaf Nodes: ");
        printTree(ansNode);
    }
}
