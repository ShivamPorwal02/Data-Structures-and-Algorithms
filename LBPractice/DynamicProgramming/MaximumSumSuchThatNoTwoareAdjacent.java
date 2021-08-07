package LoveBabbar.DynamicProgramming;

public class MaximumSumSuchThatNoTwoareAdjacent {
    int findMaxSum(int arr[], int n) {
        // code here
        int inc = arr[0];
        int exc = 0;

        // inlcusive exclusive maximum sum

        for(int i=1;i<arr.length;i++){
            int exc_new = Math.max(inc,exc);
            inc = exc+arr[i];
            exc = exc_new;
        }
        return Math.max(inc,exc);
    }
}
