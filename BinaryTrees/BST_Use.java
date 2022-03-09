package BinaryTrees;

public class BST_Use {
    public static void main(String[] args) {

        BST b = new BST();

        b.insert(5);
        b.insert(2);
        b.insert(7);
        b.insert(1);
        b.insert(3);
        b.insert(6);
        b.insert(8);

        /*
        b.insert(5);
        b.insert(2);
        b.insert(7);
        b.insert(4);
        b.insert(5);
        */

        b.printTree();
        System.out.println(b.isPresent(8));
        System.out.println(b.size());
        System.out.println();

        b.delete(5);
        b.printTree();
        System.out.println(b.isPresent(5));

//        b.printTree();

    }
}
