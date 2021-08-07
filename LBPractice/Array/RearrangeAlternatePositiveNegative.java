package LoveBabbar;

import java.util.Arrays;
import java.util.Scanner;

public class RearrangeAlternatePositiveNegative {
    void rearrange(int arr[], int n) {
        int outofIndex = -1;

        for (int i = 0; i < n; i++) {
            if (outofIndex != -1) {
                if (arr[outofIndex] >= 0 && arr[i] < 0 || arr[outofIndex] < 0 && arr[i] >= 0) {
                    rotate(arr, outofIndex, i);
                    if (i - outofIndex >= 2) outofIndex += 2;
                    else outofIndex = -1;
                }

            } else {
                if (i % 2 == 0 && arr[i] < 0 || i % 2 != 0 && arr[i] >= 0) {
                    outofIndex = i;
                }
            }
        }
    }

    public void rotate(int[] arr, int i, int j) {
        int temp = arr[j];
        for (int idx = j - 1; idx >= i; idx--) {
            arr[idx + 1] = arr[idx];
        }
        arr[i] = temp;
    }

}
