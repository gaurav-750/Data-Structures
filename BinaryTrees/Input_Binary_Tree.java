package BinaryTrees;
import java.util.Scanner;

public class Input_Binary_Tree {

    public static void printBinaryTree(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){ // if root is null, simply return as we cannot print root.data
            return;
        }
        System.out.print(root.data + ": ");
        if (root.left != null){
            System.out.print("L" + root.left.data + ", ");
        }
        if (root.right != null){
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printBinaryTree(root.left); // Recursive call on root's left (node)
        printBinaryTree(root.right); // Recursive call on root's right (node)

        return;
    }

    public static BinaryTreeNode<Integer> takeBinaryTreeInputRecursively(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        int rootData = sc.nextInt();

        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // create node for root
        BinaryTreeNode<Integer> leftChild = takeBinaryTreeInputRecursively();
        BinaryTreeNode<Integer> rightChild = takeBinaryTreeInputRecursively();

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeBinaryTreeInputRecursively();
        printBinaryTree(root);
    }
}
