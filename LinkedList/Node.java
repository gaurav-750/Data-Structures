package Linked_List_01_DS;

// Now, we not only want to store integral values but string, characters, etc too.
// Hence we'll be using GENERICS!
public class Node<T> {
    public T data;
    public Node<T> next;

            // Constructor
    public Node(T data){
        this.data = data;
        next = null;
    }

//    public void print(){
//        System.out.println(data + " " + next);
//    }

}
