package LoveBabbar.DynamicProgramming;

public class MinimumNumberofJumpstoReachEnd_O_N {
    static int minJumps(int[] arr) {
        // your code here
        if (arr[0] == 0) return -1;
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return jump;
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0) {
                jump++;

                if (i >= maxReach) return -1;
                step = maxReach - i;
            }
        }
        return -1;
    }
}