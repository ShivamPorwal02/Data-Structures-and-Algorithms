package LoveBabbar.Greedy;

import java.util.Arrays;

public class SmallestSubsetWithSumGreaterThanAllOtherElements {
    static int minElements(int arr[], int n)
    {
        // Calculating HALF of array sum
        int halfSum = 0;
        for (int i = 0; i < n; i++)
            halfSum = halfSum + arr[i];
        halfSum = halfSum / 2;


        // Sort the array in ascending order and
        // start traversing array from the ascending
        // sort in descending order.
        Arrays.sort(arr);

        int res = 0, curr_sum = 0;
        for (int i = n-1; i >= 0; i--) {

            curr_sum += arr[i];
            res++;

            // Current sum greater than sum
            if (curr_sum > halfSum)
                return res;
        }
        return res;
    }
}
