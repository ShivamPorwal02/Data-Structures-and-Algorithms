package LoveBabbar.SortingAndSearching;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumNumberofSwaptoSortArray {
    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public int minSwaps(int nums[]) {
        // Code here
        //Nlogn wala hai


        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < ans.length; i++) {
            hm.put(ans[i], i);
        }
        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(ans));
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ans[i] != nums[i]) {
                int init = ans[i];
                cnt++;
                swap(ans, i, hm.get(nums[i]));
                hm.put(init, hm.get(nums[i]));
                hm.put(nums[i], i);
            }
        }
        return cnt;
    }
}
