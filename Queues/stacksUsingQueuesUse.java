package Queues;

public class stacksUsingQueuesUse {
    public static void main(String[] args) throws QueueEmptyException {

        Stacks_Using_Queues<Integer> suQ = new Stacks_Using_Queues<>();

        System.out.println(suQ.size());
        suQ.push(10);
        suQ.push(20);
        suQ.push(30);
        suQ.push(40);
        System.out.println(suQ.size());

        System.out.println(suQ.pop());
        System.out.println(suQ.size());

//        while (suQ.size() != 0){
//            System.out.print(suQ.pop() + " ");
//        }

        System.out.println();
        System.out.println(suQ.top());
        System.out.println(suQ.size());
        System.out.println();

        while (suQ.size() != 0){
            System.out.print(suQ.pop() + " ");
        }
        System.out.println();
        System.out.println(suQ.size());

//        System.out.println(suQ.pop());
//        System.out.println(suQ.pop());
//        System.out.println(suQ.pop());
//        System.out.println(suQ.pop());
    }
}
