package HashMaps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

// Date: 11-10-2021
// 18:57
public class Inbuilt_HashmapUse {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>(); // created a hashmap
        // Here, 'key' is of type String while 'value' is of type int

        // to insert anything in hashmap
        map.put("abc", 11);
        map.put("def", 21);
        map.put("ghi", 30);
//        map.put("ghi", 31);
//        map.put("ghi", 311);
        System.out.println(map.get("ghi"));
        // to print hashmap
        System.out.println(map);

        // to check whether our hashmap contains any particular 'key'
        System.out.println(map.containsKey("abc"));
        System.out.println(map.containsKey("gaurav"));

        // to check whether our hashmap contains any particular 'value'
        System.out.println(map.containsValue(11));

        // to get 'value' for a particular key
        System.out.println(map.get("abc"));
        System.out.println(map.get("def"));
        System.out.println(map.get("defghi"));
//        int value2 = map.get("def");
//        int value3 = map.get("defghi");

        // to delete a particular 'key'
        map.remove("abc");
        System.out.println(map);

        // to get 'size' of map
        System.out.println(map.size());

        // Iteration
        System.out.println(map.keySet()); // it will print all the keys in our hashmap in the form of set
                    // or //
        Set<String> s = map.keySet();

        System.out.println(s);

        for (String str: s){ // to print all keys(not in a form of set)
            System.out.print(str + " ");
        }

        System.out.println(map.values()); // print all values of map

//        Integer i = new Integer("21279");
//        System.out.println(i.hashCode());

    }
}
