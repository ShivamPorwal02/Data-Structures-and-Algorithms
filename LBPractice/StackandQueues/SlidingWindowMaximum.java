package LoveBabbar.StackandQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    // Aditya verma ki video for reference

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length<k) return nums;

        Deque<Integer> q = new ArrayDeque<>();

        int size = nums.length;
        int[] ans = new int[nums.length-k+1];

        int idx = 0;

        int i = 0;
        int j = 0;

        while(j<size){

            while(q.size()>0 && q.peekLast()<nums[j]) q.removeLast();
            q.add(nums[j]);

            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                ans[idx] = q.peek();

                if(nums[i]==q.peek()) q.remove();
                i++;
                j++;
                idx++;
            }
        }
        return ans;
    }
}
