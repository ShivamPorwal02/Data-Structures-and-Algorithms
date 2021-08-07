package LoveBabbar.DynamicProgramming;

import java.util.TreeSet;

public class MaximumSumofRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] mat, int k) {

        int maxSum = Integer.MIN_VALUE;
        int leftBound = 0;
        int rightBound = 0;
        int upBound = 0;
        int lowBound =0;

        int r = mat.length;
        int c = mat[0].length;
        int[] temp = new int[r];

        for(int left = 0; left<c;left++){
            for(int i=0;i<r;i++) temp[i] = 0;

            for(int right = left;right<c;right++){
                for(int i=0;i<r;i++){
                    temp[i]+=mat[i][right];
                }
                int res = maxSubArray(temp,k);
                if(res>maxSum){
                    maxSum = res;
                }
            }
        }
        return maxSum;
    }
    public int maxSubArray(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            Integer ceilValue = set.ceiling(currSum - k);
            if(ceilValue != null) {
                max = Math.max(max, currSum - ceilValue);
            }
            set.add(currSum);
        }
        return max;
    }
}
