package BinaryTrees;
import java.util.*;

public class Take_Input_LevelWise_BT {
//    public int size;

    public static BinaryTreeNode<Integer> takeInputLevelWiseBT(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        int rootData = sc.nextInt();
        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root); // pushing it into queue

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

    public BinaryTreeNode<Integer> getInput(){
        return takeInputLevelWiseBT();
    }

//    public static void printBinaryTree(BinaryTreeNode<Integer> root){
//        // base case
//        if (root == null){ // if root is null, simply return as we cannot print root.data
//            return;
//        }
//        System.out.print(root.data + ": ");
//        if (root.left != null){
//            System.out.print("L" + root.left.data + ", ");
//        }
//        if (root.right != null){
//            System.out.print("R" + root.right.data);
//        }
//        System.out.println();
//
//        printBinaryTree(root.left); // Recursive call on root's left (node)
//        printBinaryTree(root.right); // Recursive call on root's right (node)
//
//        return;
//    }

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

    public void printBTree(BinaryTreeNode<Integer> root){
        printLevelWiseBT(root);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
//        printBinaryTree(root); // printing Binary Tree Recursively

        printLevelWiseBT(root); // printing Binary Tree LevelWise

    }
}
/*
HOW TO TAKE INPUT LEVELWISE:
    1. Take 'Root' input.
    2. Insert it into queue.
    3. while(!queue.isEmpty()){
            1. Take first element out from the queue.
            2. Ask for its leftChild
                if(leftChild != -1){
                        # Attach it to this element on left side
                        # Push leftChild to queue.
                    }
            3. Repeat step 2 for rightChild
        }
    4. return Root.
 */