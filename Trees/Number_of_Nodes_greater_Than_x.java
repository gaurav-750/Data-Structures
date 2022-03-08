package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number_of_Nodes_greater_Than_x {

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

    public static int numNodeGreater(TreeNode<Integer> root, int x){
        int count = 0;
        if (root.data > x){
            count++;
        }

        for (int i = 0; i < root.children.size(); i++){
            int smallOutput = numNodeGreater(root.children.get(i), x);
            count = count+smallOutput;
        }

        return count;
    }

    // Date: 20-09-2021
    // Time: 22:54
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode<Integer> root = takeInputLevelWise();
        System.out.print("Enter x: ");
        int x = sc.nextInt();

        System.out.println(numNodeGreater(root, x));
    }
}

