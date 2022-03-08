package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Take_Input_LevelWise {

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

//    public static void printTreeLevelWise(TreeNode<Integer> root){
//        Queue<TreeNode<Integer>> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()){
//            TreeNode<Integer> frontNode = queue.poll();
//            String str = frontNode.data + ": ";
//            int i = 0;
//            while (i < frontNode.children.size()){
//                str = str + frontNode.children.get(i).data + ",";
//                queue.add(frontNode.children.get(i));
//                i++;
//            }
//            System.out.println(str);
//        }
//
//    }

    public static TreeNode<Integer> removeAllLeafNodes(TreeNode<Integer> root){
        // base case
        if (root == null){
            return null;
        }

        if (root.children.size() == 0){ // leaf node
            return null;
        }
        int i =0;
        while (i < root.children.size()){
            TreeNode<Integer> smallOutput = removeAllLeafNodes(root.children.get(i));

            if (smallOutput == null){
                root.children.remove(root.children.get(i));
            }else {
                i++;
            }

//            for (int j = 0; j < root.children.size(); j++) {
//                System.out.print(root.children.get(j).data + " " + j);
//            }
//            System.out.println();
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

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();

//        printTreeLevelWise(root);
        printTree(root);

        // Test 03
        // Problem 03

        TreeNode<Integer> ans = removeAllLeafNodes(root);
        printTree(ans);
    }
}
