package LoveBabbar.Heap;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsfromKLists {
    class Pair{
        int i;
        int j;
        int data;
        Pair(int data,int i,int j){
            this.data = data;
            this.i = i;
            this.j = j;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int[][] arr = new int[nums.size()][];
        int k = nums.size();
        int total = 0;
        for(int i=0;i<nums.size();i++){
            total+=nums.get(i).size();
            arr[i] = new int[nums.get(i).size()];
            for(int j = 0;j<nums.get(i).size();j++) arr[i][j] = nums.get(i).get(j);
        }
        int[] res = new int[2];
        int n = nums.get(0).size();
        if(nums.size()==1){
            res[0] = arr[0][0];
            res[1] = arr[0][0];
            return res;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.data-b.data);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int range = Integer.MAX_VALUE;
        int maxValue =0;
        int minValue = 0;
        for(int i=0;i<k;i++){
            if(arr[i][0]>max)max = arr[i][0];
            if(arr[i][0]<min) min = arr[i][0];
            pq.add(new Pair(arr[i][0],i,0));
        }
        int tempRange = max - min;
        if(tempRange<range){
            range = tempRange;
            maxValue = max;
            minValue = min;
        }
        while(pq.size()>0){
            Pair rem = pq.remove();
            min = rem.data;
            tempRange = max - min;
            if(tempRange<range){
                range = tempRange;
                maxValue = max;
                minValue = min;
            }
            if(rem.j<nums.get((rem.i)).size()-1){
                if(arr[rem.i][rem.j+1]>max) max = arr[rem.i][rem.j+1];
                pq.add(new Pair(arr[rem.i][rem.j+1],rem.i,rem.j+1));
            }else{
                break;
            }
        }
        res[0] = minValue;
        res[1] = maxValue;

        return res;
    }
}
