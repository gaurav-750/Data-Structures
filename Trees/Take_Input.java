package Trees;
import java.util.Scanner;

public class Take_Input {

    public static TreeNode<Integer> takeInputTrees(Scanner sc){
//        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data: ");
        int n = sc.nextInt();

        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.print("Enter number of child for " + n +": ");
        int childCount = sc.nextInt();

        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInputTrees(sc);
            root.children.add(child);
        }

        return root;
    }
    
    public static void printTree(TreeNode<Integer> root){
        String str = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            str = str + root.children.get(i).data + ",";
        }
        System.out.println(str);

        for (int i = 0; i < root.children.size(); i++) {
            printTree(root.children.get(i));
        }

        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode<Integer> root = takeInputTrees(sc);
        printTree(root);

    }
}
