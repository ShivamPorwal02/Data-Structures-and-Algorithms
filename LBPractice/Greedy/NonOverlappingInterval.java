package LoveBabbar.Greedy;

import java.util.Arrays;

public class NonOverlappingInterval {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr,(a, b)->Integer.compare(a[1],b[1])); // ye overflow bchane k lia

        int n = arr.length;
        int max = 1;
        int endTime = arr[0][1];

        for(int i=1;i<n;i++){

            if(arr[i][0]>=endTime){

                max++;
                endTime = arr[i][1];
            }
        }

        return arr.length - max;
    }
}
