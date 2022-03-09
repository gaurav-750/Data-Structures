package BinaryTrees;

// Date: 21-09-2021
// 18:09
public class BinaryTreeNode<T> { // keeping our binaryTreeNode class generic
    // data members

    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

                // Constructor
    public BinaryTreeNode(T data){
        this.data = data;
    }

}
