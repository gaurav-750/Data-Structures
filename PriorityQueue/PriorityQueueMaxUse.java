package PriorityQueue;

public class PriorityQueueMaxUse {
    public static void main(String[] args) throws PriorityQueueEmptyException {

        PriorityQueueMax<Integer> pqm = new PriorityQueueMax<>();

        pqm.insert(10,20);
        pqm.insert(20,10);
        pqm.insert(30,18);
        pqm.insert(40,9);
        pqm.insert(50,7);
        pqm.insert(60,11);
        pqm.insert(70,12);

        pqm.display();
        System.out.println(pqm.size());
        System.out.println(pqm.isEmpty());
        System.out.println(pqm.getMax());

        while (!pqm.isEmpty()){
            System.out.println(pqm.removeMax());
            pqm.display();
        }


    }
}
