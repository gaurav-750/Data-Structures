package BinaryTrees;
import java.util.Scanner;

public class Balanced_Tree {

    public static BinaryTreeNode<Integer> takeInputBTree(boolean isRoot, int parentData, boolean isLeft){
        if (isRoot){
            System.out.print("Enter root data: ");
        }else {
            if (isLeft){
                System.out.print("Enter left child of " + parentData + ": ");
            }else {
                System.out.print("Enter right child of " + parentData + ": ");
            }
        }

        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // create node for root
        BinaryTreeNode<Integer> leftChild = takeInputBTree(false, rootData, true);
        BinaryTreeNode<Integer> rightChild = takeInputBTree(false,rootData, false);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

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

    public static int heightOfTree(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int smallHeight = Math.max(leftHeight, rightHeight);

        return smallHeight+1;
    }

    public static boolean isTreeBalanced(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return true;
        }

        int height_LST = heightOfTree(root.left);
        int height_RST = heightOfTree(root.right);

        if (Math.abs(height_LST - height_RST) > 1){
            return false;
        }

        boolean isLeftBalanced = isTreeBalanced(root.left);
        boolean isRightBalanced = isTreeBalanced(root.right);

        boolean result = isLeftBalanced && isRightBalanced;
        return result;
    }

    // Second approach - returning an object of class balancedTreeReturn
    // here we r returning an object(of class balancedTreeReturn) which basically would return height and a boolean isBalanced
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        if (root == null){
//            int height = 0;
//            boolean isBal = true;
            BalancedTreeReturn ans = new BalancedTreeReturn(); // creating an object of class BalancedTreeReturn
            return ans;
        }

        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);

        boolean isBal = true;
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        if (Math.abs(leftOutput.height - rightOutput.height) > 1){
            isBal = false;
        }

        if ( !leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }

//        System.out.println("height: " + height + ", " + "isBal: " + isBal);
        BalancedTreeReturn answer = new BalancedTreeReturn();
        answer.height = height;
        answer.isBalanced = isBal;

        return answer;
    }

    // Date: 23-09-2021
    // 16:44
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputBTree(true, -1, false);
        printBinaryTree(root);

//        System.out.println("Is Balanced: " + isTreeBalanced(root));
        BalancedTreeReturn result = isBalancedBetter(root);
        System.out.println(result.isBalanced);
    }
}
/*
BALANCED TREE :
    If |height of left subtree - height of right subTree| <= 1 :- then it is known as a Balanced Tree
    i.e |h(LST) - h(RST)| <= 1
    And this condition should be satisfied by 'every' node of the Tree, not just the Root.
 */

/*
Basic Approach -
    1. Find the height of LST and RST.
    2. Check for the difference of LST ans RST, it should be <= 1, otherwise return false.
    3. If true, check for left subTree and rightSubTree, whether they are balanced or not.
 */