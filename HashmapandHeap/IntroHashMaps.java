package HashmapandHeap;

import java.util.HashMap;
import java.util.Set;

public class IntroHashMaps {
    public static void main(String[] arr){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",135);
        hm.put("China",200);
        hm.put("Pak",35);
        hm.put("USA",25);
        hm.put("UK",15);


        System.out.println(hm);

        hm.put("Nigeria",10);
        hm.put("UK",10);

        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("Utopia"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Utopia"));

        Set<String> keys = hm.keySet();
        for(String key:hm.keySet()){
            int val = hm.get(key);
            System.out.println(key+" "+val);
        }
    }
}
