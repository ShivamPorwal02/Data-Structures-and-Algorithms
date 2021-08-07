package LoveBabbar.Array;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {

        int ans = 0;
        int i=0;
        int j = nums.length-1;
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;

        while(i<=j){
            int mid = (i+j)/2;

            if(nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid]) return mid;
            else if(nums[mid-1]>nums[mid]) j--;
            else i++;
        }
        return ans;
    }
}
