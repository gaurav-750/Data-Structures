package Trees;

import java.util.*;

public class Height_Of_Tree {

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

    // Date: 09-10-2021
    // 09:48
    public static int heightOfTree(TreeNode<Integer> root){
        int rootHeight = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < root.children.size(); i++) {
            int smallHeight = heightOfTree(root.children.get(i));
            list.add(smallHeight);
            rootHeight = Collections.max(list);
        }

        return rootHeight+1;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();

        System.out.println(heightOfTree(root));
    }
}
