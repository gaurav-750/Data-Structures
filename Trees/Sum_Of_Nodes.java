package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sum_Of_Nodes {

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

    public static int sumOfNodes(TreeNode<Integer> root){
        int count = root.data;

        for (int i = 0; i < root.children.size(); i++) {
            int output = sumOfNodes(root.children.get(i));
            count = count + output;
        }

        return count;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        int result = sumOfNodes(root);
        System.out.println(result);
    }
}
