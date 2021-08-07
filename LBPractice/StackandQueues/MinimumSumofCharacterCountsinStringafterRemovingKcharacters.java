package LoveBabbar.StackandQueues;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumSumofCharacterCountsinStringafterRemovingKcharacters {
    static int minValue(String s, int k){
        // code here
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Character c : hm.keySet()){
            pq.add(hm.get(c));
        }

        int sum = 0;
        while(k!=0){
            int temp = pq.remove();
            // sum = sum + temp*temp;
            pq.add(temp-1);
            k--;
        }
        while(pq.size()>0){
            int temp = pq.remove();
            sum+=temp*temp;
        }
        return sum;
    }
}
