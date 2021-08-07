package HashmapandHeap;

import java.util.HashMap;
import java.util.*;
public class GetCommonElement2 {
    public static void main(String[] args) throws Exception {
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

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<n1;i++){
            if(hm.containsKey(a1[i])){
                int ov = hm.get(a1[i]);
                int nv = ov+1;
                hm.put(a1[i],nv);
            }else{
                hm.put(a1[i],1);
            }
        }
        for(int i=0;i<n2;i++){
            if(hm.containsKey(a2[i]) && hm.get(a2[i])!=0){
                System.out.println(a2[i]);
                int ov = hm.get(a2[i]);
                int nv = ov-1;
                hm.put(a2[i],nv);
            }
        }
    }

}
