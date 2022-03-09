package BinaryTrees;

import java.util.*;

public class BST_to_LL {

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

    public static LinkedListNode<Integer> constructLL(BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.poll();
            list.add(frontNode.data);

            if (frontNode.left != null && frontNode.right != null){
                queue.add(frontNode.left);
                queue.add(frontNode.right);
            }else if (frontNode.left != null){
                queue.add(frontNode.left);
            }else if (frontNode.right != null){
                queue.add(frontNode.right);
            }

        }

        Collections.sort(list);
        LinkedListNode<Integer> head = new LinkedListNode<>(list.get(0));
        LinkedListNode<Integer> t1 = head;

        int i = 1;
        while (i < list.size()){
            LinkedListNode<Integer> newNode = new LinkedListNode<>(list.get(i));
            t1.next = newNode;
            t1 = t1.next;
            i++;
        }

        return head;
    }

    public static LinkedListNode<Integer> constructLLRecursively(BinaryTreeNode<Integer> root){
        // base case
        if (root == null){
            return null;
        }

        LinkedListNode<Integer> leftHead = constructLLRecursively(root.left);
        LinkedListNode<Integer> rightHead = constructLLRecursively(root.right);

        LinkedListNode<Integer> rootNode = new LinkedListNode<>(root.data);;
        if (leftHead == null && rightHead == null){
            return rootNode;
        }else if (leftHead == null){
            rootNode.next = rightHead;
            return rootNode;
        }else if (rightHead == null){
            LinkedListNode<Integer> t1 = leftHead;
            while (t1.next != null){
                t1 = t1.next;
            }
            t1.next = rootNode;
            return leftHead;
        }else {
            LinkedListNode<Integer> t1 = leftHead;
            while (t1.next != null){
                t1 = t1.next;
            }
            t1.next = rootNode;
            rootNode.next = rightHead;
            return leftHead;
        }

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

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWiseBT();
        printLevelWiseBT(root);

//        LinkedListNode<Integer> head = constructLL(root);
        LinkedListNode<Integer> head = constructLLRecursively(root);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }

    }
}
