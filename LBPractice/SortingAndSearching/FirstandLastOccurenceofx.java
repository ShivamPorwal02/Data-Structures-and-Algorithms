package LoveBabbar.SortingAndSearching;

public class FirstandLastOccurenceofx {
    public int[] searchRange(int[] nums, int x) {
        int[] arr = new int[2];
        int start = 0;
        int end = nums.length-1;
        int frst = -1;
        while(start<=end){
            int mid = (start+end)/2;

            if(x==nums[mid]){
                frst = mid;
                end = mid-1;
            }else if(x<nums[mid]){
                end = mid-1;
            }else if(x>nums[mid]){
                start = mid+1;
            }
        }
        start = 0;
        end = nums.length-1;
        int last = -1;
        while(start<=end){
            int mid = (start+end)/2;

            if(x==nums[mid]){
                last = mid;
                start = mid+1;
            }else if(x<nums[mid]){
                end = mid-1;
            }else if(x>nums[mid]){
                start = mid+1;
            }
        }
        arr[0] = frst;
        arr[1] = last;
        return arr;
    }
}
