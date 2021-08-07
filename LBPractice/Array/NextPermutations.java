package LoveBabbar;

public class NextPermutations {
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return ;
        }
        int i = nums.length-2;
        while(i>=0&& nums[i]>=nums[i+1]){
            i --;
        }
        if(i>=0){
            int j = nums.length-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        int x = i+1;
        int y = nums.length-1;
        while(x<y){
            swap(nums,x,y);
            x++;
            y--;
        }
    }
}
