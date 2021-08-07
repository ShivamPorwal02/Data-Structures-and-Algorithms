package LoveBabbar;

public class MaxiMumProductSubarray {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
            // 3 option hai ya to min k saath jud ya positive k saath ya khud se nya bnade
        }
        return result;
    }
    // dp bna k saath
//    int[] dpMax = new int[nums.length];
//    int[] dpMin = new int[nums.length];
//    int max = nums[0];
//
//    dpMax[0] = nums[0];
//    dpMin[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//        dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
//        dpMin[i] = Math.min(nums[i], Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
//        max = Math.max(max, Math.max(dpMax[i], dpMin[i]));
//    }
//
//        return max;
}
