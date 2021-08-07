package LoveBabbar.StackandQueues;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public int[][] merge(int[][] arr) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        s1.push(arr[0][0]);
        s2.push(arr[0][1]);
        int size = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]>=s1.peek() && arr[i][0]<=s2.peek()){
                if(arr[i][1] >s2.peek()){
                    s2.pop();
                    s2.push(arr[i][1]);
                }
            }else{
                s1.push(arr[i][0]);
                s2.push(arr[i][1]);
                size++;
            }
        }

        int[][] narr = new int[size][2];

        for(int i=size-1;i>=0;i--){
            narr[i][0] = s1.pop();
            narr[i][1] = s2.pop();
        }
        return narr;
    }
}
