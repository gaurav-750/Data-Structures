package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Check_If_Tree_Contains_x {

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

    public static boolean checkTreeContainsX(TreeNode<Integer> root, int x){
        if (root.data == x){
            return true;
        }

        for (int i = 0; i < root.children.size(); i++) {
            boolean isFound = checkTreeContainsX(root.children.get(i), x);
            if (isFound){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode<Integer> root = takeInputLevelWise();

        System.out.print("Enter x: ");
        int x = sc.nextInt();
        System.out.println(checkTreeContainsX(root, x));
    }
}
