package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TheNumberOFSmallestUnoccupiedChair {
    class Pair{
        int idx;
        int start;
        int end;
        Pair(int idx,int start,int end){
            this.idx = idx;
            this.start = start;
            this.end = end;
        }
    }
    class Pair2{
        int dptime;
        int chair;
        Pair2(int dptime,int chair){
            this.dptime = dptime;
            this.chair = chair;
        }
    }
    public int smallestChair(int[][] times, int targetFriend) {
        Pair[] arr = new Pair[times.length];
        for(int i=0;i<times.length;i++){
            arr[i] = new Pair(i,times[i][0],times[i][1]);
        }

        Arrays.sort(arr,(a, b)->a.start-b.start);

        PriorityQueue<Pair2> used = new PriorityQueue<>((a, b)->a.dptime-b.dptime);
        PriorityQueue<Integer> free = new PriorityQueue<>();

        HashMap<Integer,Integer> hm = new HashMap<>();

        int chair = 0;

        for(int i=0;i<arr.length;i++){
            while(used.size()!=0 && used.peek().dptime <= arr[i].start){
                free.add(used.remove().chair);
            }
            int chairToallot = 0;
            if(free.size()!=0){
                chairToallot = free.remove();
            }else{
                chairToallot = chair++;
            }
            if(arr[i].idx==targetFriend) return chairToallot;
            hm.put(arr[i].idx,chairToallot);
            used.add(new Pair2(arr[i].end,chairToallot));
        }
        return times.length;
    }
}
