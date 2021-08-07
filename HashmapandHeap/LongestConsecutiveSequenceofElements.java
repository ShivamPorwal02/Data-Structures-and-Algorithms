package HashmapandHeap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSequenceofElements {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = scn.nextInt();
        }
        HashMap<Integer,Boolean> hm = new HashMap<>();
        for(int val:a){
            hm.put(val,true);
        }
        for(int val:a){
            if(hm.containsKey(val-1)){
                hm.put(val,false);
            }
        }
        int max = 0;
        int ml = 0;
        for(int val:a){
            if(hm.get(val)==true){
                int cv = val;
                int cl = 1;
                while(hm.containsKey(cv+cl)){
                    cl++;
                }
                if(cl>max){
                    max = val;
                    ml = cl;
                }
            }
        }
        for (int i=0;i<ml ;i++ ) {
            System.out.println(max+i);
        }
    }
}
