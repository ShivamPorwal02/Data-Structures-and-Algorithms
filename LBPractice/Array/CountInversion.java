package LoveBabbar;

import java.util.Scanner;

public class CountInversion {
    static long cnt = 0;

    public static boolean isSorted(long[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isReverseSorted(long[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    static long inversionCount(long arr[], long N) {
        // Your Code Here
        if (isSorted(arr)) {
            return 0;
        }
        if (isReverseSorted(arr)) {
            return (arr.length * (arr.length - 1)) / 2;
        }
        long[] ans = mergeSort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(ans));
        return cnt;
    }

    public static long[] mergeSort(long[] arr, int left, int right) {
        if (left == right) {
            long[] x = new long[1];
            x[0] = arr[left];
            return x;
        }
        int mid = (left + right) / 2;
        long[] a = mergeSort(arr, left, mid);
        long[] b = mergeSort(arr, mid + 1, right);

        return merge(a, b);
    }

    public static long[] merge(long[] a, long[] b) {
        long[] ans = new long[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                ans[k] = a[i];
                i++;
                k++;
            } else {
                ans[k] = b[j];
                k++;
                j++;
                cnt += (a.length - i);
            }
        }
        while (i < a.length) {
            ans[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            ans[k] = b[j];
            j++;
            k++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextInt();
        long[] arr = new long[(int)n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        long ans = inversionCount(arr,n);
        System.out.println(cnt);
    }
}
