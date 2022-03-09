package BinaryTrees;
import java.util.*;

public class Minimum_Maximum_in_BTree {

    public static BinaryTreeNode<Integer> takeInputLevelWiseBT(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        int rootData = sc.nextInt();
        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.poll();
            System.out.print("Enter left child of " + frontNode.data + ": ");
            int leftChild = sc.nextInt();
            if (leftChild != -1){
                BinaryTreeNode<Integer> leftChildNode = new BinaryTreeNode<>(leftChild);
                frontNode.left = leftChildNode;
                queue.add(leftChildNode);
            }

            System.out.print("Enter right child of " + frontNode.data + ": ");
            int rightChild = sc.nextInt();
            if (rightChild != -1){
                BinaryTreeNode<Integer> rightChildNode = new BinaryTreeNode<>(rightChild);
                frontNode.right = rightChildNode;
                queue.add(rightChildNode);
            }

        }

        return root;
    }

    public static int maximumData(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return -1;
        }

        int leftMax = maximumData(root.left);
        int rightMax = maximumData(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static int minimumData(BinaryTreeNode<Integer> root){
        //base case
        if (root == null){
            return Integer.MAX_VALUE;
        }

        int leftMin = minimumData(root.left);
        int rightMin = minimumData(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root){
        int min = minimumData(root);
        int max = maximumData(root);

        Pair<Integer, Integer> answer = new Pair<>(min, max);
        return answer;
    }

    public static void printLevelWiseBT(BinaryTreeNode<Integer> root){
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.poll();
            System.out.print(frontNode.data + ": ");

            if (frontNode.left != null && frontNode.right != null){
                System.out.print("L" + frontNode.left.data + ", " + "R" + frontNode.right.data);
                queue.add(frontNode.left);
                queue.add(frontNode.right);
            }else if (frontNode.left != null){
                System.out.print("L" + frontNode.left.data);
                queue.add(frontNode.left);
            }else if (frontNode.right != null){
                System.out.print("R" + frontNode.right.data);
                queue.add(frontNode.right);
            }
            System.out.println();
        }

    }

    // Date: 02-10-2021
    // 17:49
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

        Pair<Integer, Integer> result = getMinAndMax(root);
        System.out.println(result.minimum + " " + result.maximum);
    }
}
