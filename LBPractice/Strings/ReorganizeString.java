package LoveBabbar.Strings;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i =0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            if(hm.get(s.charAt(i))>s.length()/2+1){
                return "";
            }
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b)-> hm.get(b)-hm.get(a));
        maxHeap.addAll(hm.keySet());

        StringBuilder res = new StringBuilder();

        while(maxHeap.size()>1){
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            res.append(current);
            res.append(next);
            hm.put(current,hm.get(current)-1);
            hm.put(next,hm.get(next)-1);
            if(hm.get(current)>0){
                maxHeap.add(current);
            }
            if(hm.get(next)>0){
                maxHeap.add(next);
            }
        }
        if(!maxHeap.isEmpty()){
            char last = maxHeap.remove();
            if(hm.get(last)>1){
                return "";
            }else{
                res.append(last);
            }
        }
        return res.toString();
    }
}
