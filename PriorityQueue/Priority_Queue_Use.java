package PriorityQueue;

public class Priority_Queue_Use {
    public static void main(String[] args) throws PriorityQueueEmptyException {

        Priority_Queue<Integer> pq = new Priority_Queue<>();

//        pq.insert("abc", 15);
//        pq.insert("def", 13);
//        pq.insert("ghi", 90);
//        pq.insert("jkl", 150);
//        pq.insert("mno", 120);
//
//        pq.display();
//
//        while (!pq.isEmpty()){
//            System.out.println(pq.getMin());
//            pq.removeMin();
//        }

        pq.insert(1,3);
        pq.insert(2,4);
        pq.insert(3,63);
        pq.insert(4,21);
        pq.insert(5,9);

        System.out.println(pq.getMin());
        pq.display();

        System.out.println(pq.removeMin());
        pq.display();

        pq.insert(7,7);
        pq.display();
        System.out.println(pq.getMin());
        System.out.println(pq.getMin());
        System.out.println(pq.getMin());

        System.out.println(pq.removeMin());
        pq.display();
        System.out.println(pq.removeMin());
        pq.display();
        System.out.println(pq.removeMin());
        pq.display();




    }
}
