package LoveBabbar.Greedy;

public class SumofAbsoluteDifference {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 0;
        for(int i=1;i<nums.length;i++){
            sum+=(Math.abs(nums[0]-nums[i]));
        }
        ans[0] = sum;
        int j = 1;

        while(j<nums.length){
            sum = sum + (nums[j]-nums[j-1])*(j-1) - (nums[j]-nums[j-1])*(nums.length-j-1);
            ans[j] = sum;
            j++;
        }
        return ans;
    }
}
