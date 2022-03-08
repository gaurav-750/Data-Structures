package Trees;
import java.util.ArrayList;

public class TreeNode<T> { // we are making this 'TreeNode' class generic - meaning,
    // we would be able to store any kind of data, be it int, char, String, long, double..etc

    // data members :
    public T data;
    public ArrayList<TreeNode<T>> children;

                // Constructor :
    public TreeNode(T data){
        this.data = data;
        children = new ArrayList<>();
    }

}
