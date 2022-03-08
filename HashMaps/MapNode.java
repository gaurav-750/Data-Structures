package HashMaps;

public class MapNode<K, V> { // Linked List in our ArrayList

    // data members
    // In our node we'll have key, value and address of next node:
    K key;
    V  value;
    MapNode<K, V> next; // next will also have type MapNode

                // Constructor
    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
    }

}
