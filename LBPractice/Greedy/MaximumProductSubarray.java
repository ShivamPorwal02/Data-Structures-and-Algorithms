package LoveBabbar.Greedy;

public class MaximumProductSubarray {
    long maxProduct(int[] A, int n) {
        // code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            long temp = max;
            max = Math.max(Math.max(temp * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
