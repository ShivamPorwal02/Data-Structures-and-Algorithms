package Revision;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = (int) Math.floor(nums.length / 3);
        List<Integer> lst = new ArrayList<>();
        int c1 = Integer.MIN_VALUE;
        int c2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == c1) {
                cnt1 += 1;
            } else if (nums[i] == c2) {
                cnt2 += 1;
            } else if (cnt1 == 0) {
                cnt1++;
                c1 = nums[i];
            } else if (cnt2 == 0) {
                c2 = nums[i];
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == c1) {
                x++;
            }
            if (nums[i] == c2) {
                y++;
            }
        }
        if (x > n) {
            lst.add(c1);
        }
        if (y > n) {
            lst.add(c2);
        }
        return lst;
    }
}
