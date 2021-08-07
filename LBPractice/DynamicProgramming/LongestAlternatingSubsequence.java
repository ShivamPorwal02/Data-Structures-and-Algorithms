package LoveBabbar.DynamicProgramming;

public class LongestAlternatingSubsequence {
    public int wiggleMaxLength(int[] nums) {
        // agr N2 ka dekhna hai to wiggle subsequence k naam se hoga

        // ism simultaneously update krte jaare hai
        // gfg article agr ab bhi smjh ni aaya to

        if(nums.length==1) return 1;

        int inc = 1;
        int dec= 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                inc = dec+1;
            }
            else if(nums[i]<nums[i-1]){
                dec = inc+1;
            }
        }
        return Math.max(inc,dec);
    }
}
