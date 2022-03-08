package Trees;

import java.util.*;

public class Second_Largest_Element {

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

    public static int secondLargestElement(ArrayList<Integer> tempList){
        Collections.sort(tempList);
        System.out.println(tempList);

        int largestElem = tempList.get(tempList.size() - 1);
        int secondLargest = -1;
        int i = tempList.size()-2;
        while (i >= 0){
            if (tempList.get(i) < largestElem){
                secondLargest = tempList.get(i);
                break;
            }
            i--;
        }

        return secondLargest;
    }

    public static TreeNode<Integer> secondLargestNumber(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root); // add root to queue
        ArrayList<Integer> list = new ArrayList<>(); // arrayList for storing nodes data
        ArrayList<Integer> tempList = new ArrayList<>(); // arrayList for storing same values as list
        ArrayList<TreeNode<Integer>> nodeList = new ArrayList<>(); // arrayList for storing nodes

        while (!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.poll();
            list.add(frontNode.data);
            tempList.add(frontNode.data);
            nodeList.add(frontNode);

            for (int i = 0; i < frontNode.children.size(); i++) {
                queue.add(frontNode.children.get(i));
            }
        }

        if (list.size() == 1){ // if tree contains only root, return null
            return null;
        }
        int elem = list.get(0);
        boolean allSameElements = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != elem){
                allSameElements = false;
                break;
            }
        }
        if (allSameElements){ // if tree contains all same elements, return null
            return null;
        }

        int secondLargestElem = secondLargestElement(tempList);
        int reqIndex = list.indexOf(secondLargestElem);

        return nodeList.get(reqIndex);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();

        TreeNode<Integer> result = secondLargestNumber(root);
        if (result != null) {
            System.out.println(result.data);
        }
    }
}
