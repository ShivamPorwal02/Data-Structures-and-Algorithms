package HashmapandHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapsIntroductionandUses {
    public static void main(String[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        PriorityQueue<Integer> pqreverse = new PriorityQueue<>(Collections.reverseOrder());

        int[] ranklist = {1,2,5,88,43,77};
        for(int val:ranklist){
            pq.add(val);
        }
        // NlogN lega ye kyuki logn add ka to N elements hai islia nlogn
        while(pq.size()>0){
            int val = pq.peek();
            pq.remove();
            System.out.println(val);
        }
        // remove bhi nlogn hi lega same reason

        for(int val:ranklist){
            pqreverse.add(val);
        }
        // NlogN lega ye kyuki logn add ka to N elements hai islia nlogn
        while(pqreverse.size()>0){
            int val = pqreverse.peek();
            pqreverse.remove();
            System.out.println(val);
        }
    }
}
