package BinaryTrees;
import java.util.*;

public class Construct_Tree_Using_Preorder_Inorder {

    public static int root_Index(int[] arrInorder, int rootData){
        int i = 0;
        while (i < arrInorder.length){
            if (arrInorder[i] == rootData){
                break;
            }
            i++;
        }

        return i;
    }

    // Method 1 - By creating copies of arrays
//    public static BinaryTreeNode<Integer> buildTree(int[] arrPreorder, int[] arrInorder){
//        if (arrPreorder.length == 0){
//            return null;
//        }
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arrPreorder[0]);
//        if (arrPreorder.length == 1){
//            return root;
//        }
//
//        int rootData = arrPreorder[0];
//        int rootIndex = root_Index(arrInorder, rootData);
////        System.out.println("rootIndex = " + rootIndex);
//
//        // creating Left Preorder Array:
//        int[] leftPreorder = new int[rootIndex];
//        for (int i = 0; i < leftPreorder.length; i++) {
//            leftPreorder[i] = arrPreorder[i+1];
//        }
//        // creating Right Preorder Array:
//        int[] rightPreorder = new int[arrPreorder.length-rootIndex-1];
//        for (int i = 1; i <= rightPreorder.length; i++) {
//            rightPreorder[i-1] = arrPreorder[i+rootIndex];
//        }
//
//        // creating Left Inorder Array:
//        int[] leftInorder = new int[rootIndex];
//        for (int j = 0; j < leftInorder.length; j++) {
//            leftInorder[j] = arrInorder[j];
//        }
//        // creating Right Inorder Array:
//        int[] rightInorder = new int[arrInorder.length-rootIndex-1];
//        for (int j = 1; j <= rightInorder.length ; j++) {
//            rightInorder[j-1] = arrInorder[j+rootIndex];
//        }
//
//        BinaryTreeNode<Integer> leftNode = buildTree(leftPreorder, leftInorder);
//        root.left = leftNode;
//        BinaryTreeNode<Integer> rightNode = buildTree(rightPreorder, rightInorder);
//        root.right = rightNode;
//
//        return root;
//    }

    public static int rootIndex(int[] in, int rootData, int siIn, int eiIn){
        int i = 0;
        while (i < in.length){
            if (in[i] == rootData){
                break;
            }
            i++;
        }

        return i;
    }

    public static BinaryTreeNode<Integer> buildTreeWithoutCopies(int[] pre, int[] in, int siPre, int eiPre, int siIn, int eiIn){
        // base case
        if (siPre > eiPre){
            return null;
        }
        int rootData = pre[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = rootIndex(in, rootData, siIn, eiIn);
        System.out.println("rootIndex = " + rootIndex);

        int siPreLeft = siPre+1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex-1;
        int eiPreRight = eiPre;
        int siInRight = rootIndex+1;
        int eiInRight = eiIn;

        int leftSubTreeLength = eiInLeft-siInLeft +1;
        int eiPreLeft = siPreLeft+leftSubTreeLength-1;
        int siPreRight = eiPreLeft+1;

        BinaryTreeNode<Integer> left = buildTreeWithoutCopies(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        root.left = left;

        BinaryTreeNode<Integer> right = buildTreeWithoutCopies(pre, in, siPreRight, eiPreRight, siInRight, eiInLeft);
        root.right = right;

        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] pre, int[] in){
        BinaryTreeNode<Integer> root = buildTreeWithoutCopies(pre, in, 0, pre.length-1, 0, in.length-1);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTreeWithoutCopiesPostIn(int[] post, int[] in, int siPost, int eiPost, int siIn, int eiIn){
        // base case
        if (siPost > eiPost){
            return null;
        }
        int rootData = post[eiPost];
//        System.out.println("rootData = " + rootData);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = rootIndex(in, rootData, siIn, eiIn);
//        System.out.println("rootIndex = " + rootIndex);

        int siPostLeft = siPost;
        int siInLeft = siIn;
        int eiInLeft = rootIndex-1;
        int eiPostRight = eiPost-1;
        int siInRight = rootIndex+1;
        int eiInRight = eiIn;

        int lengthLeftSubTree = eiInLeft-siInLeft+1;
        int eiPostLeft = siPostLeft+lengthLeftSubTree-1;
        int siPostRight = eiPostLeft+1;

        BinaryTreeNode<Integer> Left = buildTreeWithoutCopiesPostIn(post, in, siPostLeft, eiPostLeft, siInLeft, eiInLeft);
        root.left = Left;
        BinaryTreeNode<Integer> Right = buildTreeWithoutCopiesPostIn(post, in, siPostRight, eiPostRight, siInRight, eiInRight);
        root.right = Right;

        return root;
    }

    public static BinaryTreeNode<Integer> buildTreePostIn(int[] post, int[] in){
        BinaryTreeNode<Integer> root = buildTreeWithoutCopiesPostIn(post, in, 0, post.length-1, 0, in.length-1);
        return root;
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
    // 15:00
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes in Tree: ");
        int n = sc.nextInt();

        int[] pre = {1,2,4,5,3,6};
        int[] in = {4,2,5,1,6,3};
//
        BinaryTreeNode<Integer> root = buildTree(pre, in);
//        printLevelWiseBT(root);

//        int[] post = {4,5,2,6,7,3,1};
//        int[] in = {4,2,5,1,6,3,7};
//        BinaryTreeNode<Integer> root = buildTreePostIn(post, in);
        printLevelWiseBT(root);
    }
}
