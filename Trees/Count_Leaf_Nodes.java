package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Count_Leaf_Nodes {

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

    public static int countLeafNodes(TreeNode<Integer> root){
        // base case
        if (root.children.size() == 0){
            return 1;
        }

        int numLeafNodes = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int childLeafNode = countLeafNodes(root.children.get(i));
            numLeafNodes = numLeafNodes+childLeafNode;
        }

        return numLeafNodes;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();

        System.out.println(countLeafNodes(root));
    }
}
