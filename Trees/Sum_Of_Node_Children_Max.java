package Trees;
import java.util.*;

public class Sum_Of_Node_Children_Max {

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

                        // Iterative Approach :
    public static TreeNode<Integer> maxSumNodeChildren(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int nodeSum;
        ArrayList<Integer> sumList = new ArrayList<>();
        ArrayList<TreeNode<Integer>> nodeList = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.poll();
            nodeSum = frontNode.data;

            for (int i = 0; i < frontNode.children.size(); i++) {
                queue.add(frontNode.children.get(i));
                nodeSum = nodeSum + frontNode.children.get(i).data;
            }

            sumList.add(nodeSum);
            nodeList.add(frontNode);
        }

        int maxSum = Collections.max(sumList);
        int indexOfMaxSum = sumList.indexOf(maxSum);

        return nodeList.get(indexOfMaxSum);
    }

    public static void maxNodeSumHelper(TreeNode<Integer> root, ArrayList<TreeNode<Integer>> nodeList, ArrayList<Integer> sumList){
        int nodeSum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            nodeSum = nodeSum + root.children.get(i).data;
        }
        sumList.add(nodeSum);
        nodeList.add(root);

        for (int i = 0; i < root.children.size(); i++) {
            maxNodeSumHelper(root.children.get(i), nodeList, sumList);
        }

        return;
    }
                    // Recursive Approach :
    public static TreeNode<Integer> maxNodeSum(TreeNode<Integer> root){
        ArrayList<TreeNode<Integer>> nodeList = new ArrayList<>();
        ArrayList<Integer> sumList = new ArrayList<>();

        maxNodeSumHelper(root, nodeList, sumList); // calling helper function

        int maxSum = Collections.max(sumList); // Finding the 'max' in sumList
        int indexOfMaxSum = sumList.indexOf(maxSum); // Finding the 'index' of the max in sumList
        return nodeList.get(indexOfMaxSum); // Returning the node from nodeList
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();

//        TreeNode<Integer> result = maxSumNodeChildren(root);
//        System.out.println(result.data);
        TreeNode<Integer> result = maxNodeSum(root);
        System.out.println(result.data);
    }
}
