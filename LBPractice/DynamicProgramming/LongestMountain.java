package LoveBabbar.DynamicProgramming;

public class LongestMountain {
    public int longestMountain(int[] A) {
        int n = A.length;
        if(n < 3){
            return 0;
        }

        // continuos hona chahia mountain definition m pdhlo
        // islia aese kia hai

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 1; i < n; i++){
            if(A[i] > A[i-1]){
                left[i] = left[i-1] + 1;
            }
        }

        for(int i = n - 2; i > 0; i--){
            if(A[i] > A[i + 1]){
                right[i] = right[i+1] + 1;
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(left[i] >0  && right[i]>0){
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
