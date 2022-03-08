package HashMaps;
import java.util.ArrayList;

// We are implementing our own map(hashmap) class
/*
    We are making our map class as Generic, as Key and value can have any type, eg.Integer, String,
    Boolean, Character,etc
 */
public class map<K, V> {
    // data members

    ArrayList<MapNode<K, V>> bucketList; // ArrayList of Linked List(MapNode), named bucketList
    int count; // how many elements are present in our bucketList
    int numBuckets;

            // Constructor
    public map(){
        bucketList = new ArrayList<>(20); // initialisation of ArrayList
        numBuckets = 5;
        for (int i = 0; i < numBuckets; i++) {
            bucketList.add(null);
        }
    }

    // this function will provide the index where the element is to be stored (bucketIndex):
    private int getBucketIndex(K key){
        int hc = key.hashCode(); // '.hashCode()' is an internal function which provides us with hashcode
        int index = hc%numBuckets; // compression

        return index; // we got our index!
    }

    private void reHash(){
        ArrayList<MapNode<K, V>> temp = bucketList;

        bucketList = new ArrayList<>();
        for (int i = 0; i < 2*numBuckets; i++) {
            bucketList.add(null);
        }
        count = 0;
        numBuckets = numBuckets*2;

        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null){
                Insert(head.key, head.value);
                head = head.next;
            }
        }

    }

    public double loadFactor(){
        return (1.0*count)/numBuckets;
    }

                // Insert Function
    public void Insert(K key, V value){
        int bucketIndex = getBucketIndex(key); // index where the element is to be stored

        MapNode<K, V> head = bucketList.get(bucketIndex); //first get the head of LList of bucketIndex

        // check whether element is already present
        // if head is null, that means there is no LList present at that index yet!
        // If key is already present, update its value - as key are unique.
        while (head!=null){
            if (head.key.equals(key)){ // if the key is already present there, update its value.
                head.value = value;
                return;
            }
            head = head.next;
        }

        // element is not there
        // insert at 0th position of LinkedList
        /*
            1. Store head first.
            2. Create a new Node(MapNode) with given key and value.
            3. newNode will be the head of that LList at that index.
            4. Whatever the previous head was, will become the next of newNode.
         */
        head = bucketList.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<K, V>(key, value); // creating a newNode
        newNode.next = head;
        bucketList.set(bucketIndex, newNode); // updating the head of bucketIndex
        count++; // increment the count of elements (key, value)pairs.

        double loadFactor = (1.0*count)/numBuckets;
        if (loadFactor > 0.7){
            reHash();
        }

    }

        // Tells us size of the hashmap
    public int size(){
        return count;
    }

        // Function for getting the value for a given key
    /*
        1. We'll find out the index(bucketIndex) of the given key.
        2. Once we get index, we will traverse through the LList present at that index
        and match the key.
        3. If we didn't find the key, that means it's not present there, hence we return null in that case.
     */
    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucketList.get(bucketIndex); //first get the head of LList of bucketIndex

        while (head != null){
            if (head.key.equals(key)){ // if we get the key, just return its value
                return head.value;
            }
            head = head.next;
        }

        return null; // if key is not found
    }

        // Function for removing a given key
    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucketList.get(bucketIndex); //first get the head of LList of bucketIndex
        MapNode<K, V> previousNode = null;

        while (head != null){
            if (head.key.equals(key)){
                if (previousNode != null){
                    previousNode.next = head.next;
                }else { // means we found key at head only! (as previousNode = null)
                    bucketList.set(bucketIndex, head.next);
                }
                count--; // decrement the count (as a number is deleted)
                return head.value;
            }
            previousNode = head;
            head = head.next;
        }

        return null;
    }

}
