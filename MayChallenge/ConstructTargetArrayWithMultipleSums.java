package MayChallenge;

import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b-a));
        long totalSum  = 0;
        for(int val : target){
            pq.add(val);
            totalSum+=val;
        }

        while(!pq.isEmpty()){
            int max = pq.remove();
            long remainingTotal = totalSum - max;

            if(max==1 || remainingTotal==1){
                return true;
            }
            if(remainingTotal==0 || max<remainingTotal){
                // max < remiainingTotal islia false hai kyuki
                // agr remainingtotal hi max se jyda hai to remainingtotal + something se kaise bnn jaaega max
                return false;
            }

            int updateMax = (int)(max%remainingTotal);

            if(updateMax==0){
                return false;
            }
            pq.add(updateMax);
            totalSum = remainingTotal+updateMax;
        }
        return true;

    }
}
