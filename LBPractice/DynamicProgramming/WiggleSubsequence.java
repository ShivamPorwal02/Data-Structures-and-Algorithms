package LoveBabbar.DynamicProgramming;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1) return 1;
        int[] inc = new int[nums.length];
        int[] dec = new int[nums.length];
        int omax = 0;
        inc[0] = 1;
        dec[0] = 1;

        for(int i=1;i<nums.length;i++){
            int minc = 0;
            int mdec = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    minc = Math.max(minc,dec[j]);
                }
                if(nums[j]>nums[i]){
                    mdec = Math.max(mdec,inc[j]);
                }
            }
            inc[i] = 1 + minc;
            dec[i] = 1 + mdec;

            if(inc[i]>omax) omax = inc[i];
            if(dec[i]>omax) omax = dec[i];
        }
        return omax;
    }

    // O(N) m

    public int wiggleMaxLength_(int[] nums) {
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
