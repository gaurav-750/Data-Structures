package Trees;

import java.util.*;
// Date: 20-09-2021
// Time: 22:53
public class Next_Larger_Element {

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

    public static TreeNode<Integer> nextLargerElement(TreeNode<Integer> root, int n){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode<Integer>> nodeList = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.poll();
            if (frontNode.data > n){
                list.add(frontNode.data);
                nodeList.add(frontNode);
            }

            for (int i = 0; i < frontNode.children.size(); i++) {
                queue.add(frontNode.children.get(i));
            }
        }
        if (list.size() == 0){ // if no number in node is greater than n, return null
            return null;
        }

        int minNumber = Collections.min(list);
        int indexNextNum = list.indexOf(minNumber);

        return nodeList.get(indexNextNum);
    }

    // Date: 20-09-2021
    // Time: 22:52
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode<Integer> root = takeInputLevelWise();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        TreeNode<Integer> result = nextLargerElement(root, n);
        System.out.println(result.data);
    }
}
