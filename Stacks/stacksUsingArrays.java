package Stacks;

public class stacksUsingArrays {

    private int[] arr; // creating an array
    private int topIndex; // index of the topmost element

    public stacksUsingArrays(){ // Empty Constructor
        arr = new int[1]; // specifying initial size
        topIndex = -1;
    }

    public stacksUsingArrays(int sizeOfStack){
        arr = new int[sizeOfStack];
        topIndex = -1;
    }

    // Time Complexity = O(1)
    public void push(int element) throws stackFullException { // Inserting elements
        // If stack is full
        if (topIndex == arr.length-1){
            // Throw Exception
//           stackFullException e = new stackFullException();
//           throw e;

            doubleCapacity();
        }

        topIndex = topIndex+1;
        System.out.println(topIndex);
        arr[topIndex] = element;
    }

    private void doubleCapacity(){
//        System.out.println("Double capacity!");
        int[] temp_arr = arr;
        arr = new int[2*temp_arr.length];
        for (int j = 0; j < temp_arr.length; j++) {
            arr[j] = temp_arr[j];
        }
    }

    // Time Complexity = O(1)
    public int top() throws stackEmptyException{
        // raising an exception :
        if (topIndex == -1){
            stackEmptyException emp = new stackEmptyException();
            throw emp;
        }

        return arr[topIndex];
    }

    // Time Complexity = O(1)
    public int pop() throws stackEmptyException { // to remove topmost element
        // raising an exception :
        if (topIndex == -1){
            stackEmptyException emp = new stackEmptyException();
            throw emp;
        }

        int temp = arr[topIndex];
        topIndex = topIndex-1;

        return temp;
    }

    // Time Complexity = O(1)
    public int size(){ // returning the size of Stack
        return topIndex+1;
    }

    // Time Complexity = O(1)
    public boolean isEmpty(){ // checking whether stack is empty or not
        return topIndex == -1;
    }

}
