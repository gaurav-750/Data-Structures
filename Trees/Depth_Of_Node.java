package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Depth_Of_Node {

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

    public static void nodeAtDepthK(TreeNode<Integer> root, int k){
        // base case
        if (k == 0){
            // print node's data
            System.out.println(root.data);
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            nodeAtDepthK(root.children.get(i), k-1);
        }

        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode<Integer> root = takeInputLevelWise();
        System.out.print("Enter depth k: ");
        int k = sc.nextInt();

        nodeAtDepthK(root, k);
    }
}
/*
DEPTH OF A NODE:
    Distance of a node from the root.

    ** Remember ** - Height is a property of a Tree, whereas Depth is a property of a node.
 */