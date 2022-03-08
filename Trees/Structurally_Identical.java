package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Structurally_Identical {

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

    public static ArrayList<Integer> postOrderList(TreeNode<Integer> root, ArrayList<Integer> listRoot){

        for (int i = 0; i < root.children.size(); i++) {
            postOrderList(root.children.get(i), listRoot);
        }

        listRoot.add(root.data);
        return listRoot;
    }

    public static ArrayList<Integer> preOrderList(TreeNode<Integer> root, ArrayList<Integer> listRoot){
        listRoot.add(root.data);

        for (int i = 0; i < root.children.size(); i++) {
            preOrderList(root.children.get(i), listRoot);
        }

        return listRoot;
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        ArrayList<Integer> listRoot1 = new ArrayList<>();
        ArrayList<Integer> list1_post = postOrderList(root1, listRoot1);

        ArrayList<Integer> listRoot2 = new ArrayList<>();
        ArrayList<Integer> list2_post = postOrderList(root2, listRoot2);

        listRoot1 = new ArrayList<>();
        ArrayList<Integer> list1_pre = preOrderList(root1, listRoot1);

        listRoot2 = new ArrayList<>();
        ArrayList<Integer> list2_pre = preOrderList(root2, listRoot2);

        return list1_post.equals(list2_post) && list1_pre.equals(list2_pre);
    }

    public static void main(String[] args) {

        TreeNode<Integer> root1 = takeInputLevelWise();
        TreeNode<Integer> root2 = takeInputLevelWise();

        System.out.println(checkIdentical(root1, root2));
    }
}
