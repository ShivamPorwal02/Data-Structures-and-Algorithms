package LeetCode;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        // test case : 1 2 3 4 5 6 7
        // 7 6 5 4 3 2 1
        // 5 6 7 4 3 2 1
        // 5 6 7 1 2 3 4

        k = k%nums.length;
        if(k==0) return;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int i,int j){
        int temp1 = i;
        int temp2 = j;

        while(temp1<temp2){
            int temp = nums[temp1];
            nums[temp1] = nums[temp2];
            nums[temp2] = temp;
            temp1++;
            temp2--;
        }
    }
}

