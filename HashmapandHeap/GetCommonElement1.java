package HashmapandHeap;

import java.util.HashMap;
import java.util.*;
public class GetCommonElement1 {
    public static void main(String[] arr){
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] a1 = new int[n1];
    for(int i=0;i<n1;i++){
        a1[i] = scn.nextInt();
    }
    int n2 = scn.nextInt();
    int[] a2 = new int[n2];
    for(int i=0;i<n2;i++){
        a2[i] = scn.nextInt();
    }
    HashMap<Integer,Boolean> hm = new HashMap<>();

    for(int i=0;i<n1;i++){
        hm.put(a1[i],true);
    }
    // System.out.println(hm);
    for(int i=0;i<n2;i++){
        if(hm.containsKey(a2[i])){
            System.out.println(a2[i]);
            hm.remove(a2[i]);
            // System.out.println(hm);
        }
    }
}
}
