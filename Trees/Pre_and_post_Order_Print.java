package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pre_and_post_Order_Print {

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

    public static void preOrderPrint(TreeNode<Integer> root){
        System.out.print(root.data + " ");

        for (int i = 0; i < root.children.size(); i++) {
            preOrderPrint(root.children.get(i));
        }

        return;
    }

    public static void postOrderPrint(TreeNode<Integer> root){

        for (int i = 0; i < root.children.size(); i++) {
            postOrderPrint(root.children.get(i));
        }

        System.out.print(root.data + " ");
        return;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();

        // Preorder:
        preOrderPrint(root);
        System.out.println();

        // Postorder:
        postOrderPrint(root);
    }
}
