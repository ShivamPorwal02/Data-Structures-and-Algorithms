package LoveBabbar.Greedy;

import java.util.Arrays;

public class NmeetingsinSingleRoom {
    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int max = 1;
        int endTime = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] > endTime) {
                max++;
                endTime = arr[i][1];
            }
        }

        return max;
    }
}
