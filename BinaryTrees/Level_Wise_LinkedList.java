package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Level_Wise_LinkedList {

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

    public static ArrayList<LinkedListNode<Integer>> levelWiseLinkedList(BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }
        ArrayList<LinkedListNode<Integer>> LLHeadList = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int treeHeight = heightOfTree(root);
        int h = 0;

        int n = 1;
        int c = 0;
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> newNode = null;
        LinkedListNode<Integer> t1 = null;
        while (h < treeHeight){
            if (n == 0){
                head = null;
                newNode = null;
                t1 = null;

                n = c;
                c = 0;
            }

            while (n != 0){
                BinaryTreeNode<Integer> frontNode = queue.poll();
                if (head == null){
                    head = new LinkedListNode<>(frontNode.data);
                    t1 = head;
                }else {
                    newNode = new LinkedListNode<>(frontNode.data);
                    t1.next = newNode;
                    t1 = t1.next;
                }
                // adding children to queue:
                if (frontNode.left != null && frontNode.right != null){
                    queue.add(frontNode.left);
                    queue.add(frontNode.right);
                    c+=2;
                }else if (frontNode.left != null){
                    queue.add(frontNode.left);
                    c++;
                }else if (frontNode.right != null){
                    queue.add(frontNode.right);
                    c++;
                }

                n--;
            }
            LLHeadList.add(head);
            h++;
        }

        return LLHeadList;
    }

    public static ArrayList<LinkedListNode<Integer>> levelWiseLL(BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }
        ArrayList<LinkedListNode<Integer>> LLHeadList = new ArrayList<>();
        int treeHeight = heightOfTree(root);
        int h = 0;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int n = 1;
        int children = 0;


        while (h < treeHeight){
            LinkedListNode<Integer> head = null;
            LinkedListNode<Integer> newNode = null;
            LinkedListNode<Integer> t1 = null;

            int k = 1;
            if (n == 0){
                n = children;
                children = 0;
            }
            while (n != 0){
                BinaryTreeNode<Integer> frontNode = queue.poll();
                k--;
                if (k == 0){
                    head = new LinkedListNode<>(frontNode.data);
                     t1 = head;
                }else {
                    newNode = new LinkedListNode<>(frontNode.data);
                    t1.next = newNode;
                    t1 = t1.next;
                }
                // adding children to queue:
                if (frontNode.left != null && frontNode.right != null){
                    queue.add(frontNode.left);
                    queue.add(frontNode.right);
                    children+=2;
                }else if (frontNode.left != null){
                    queue.add(frontNode.left);
                    children++;
                }else if (frontNode.right != null){
                    queue.add(frontNode.right);
                    children++;
                }

                n--;
            }

            LLHeadList.add(head);
            h++;
        }

        return LLHeadList;
    }



    public static void printLevelWiseBT(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
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

    public static void print(LinkedListNode<Integer> head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);


//        ArrayList<LinkedListNode<Integer>> output = levelWiseLL(root);
        ArrayList<LinkedListNode<Integer>> output = levelWiseLinkedList(root);
        if (output!=null){
            for (LinkedListNode<Integer> head : output){
                print(head);
                System.out.println();
            }
        }

    }
}
