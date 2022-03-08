package HashMaps;

public class MapUse {
    public static void main(String[] args) {

        map<String, Integer> myMap = new map<String, Integer>();

        for (int i = 0; i < 20; i++) {
            myMap.Insert("abc"+i, i+1);
            System.out.println(myMap.loadFactor());
        }

        myMap.removeKey("abc3");
        myMap.removeKey("abc7");
        for (int i = 0; i < 20; i++) {
            System.out.println("abc"+i + "," + myMap.getValue("abc"+i));
        }


    }
}
