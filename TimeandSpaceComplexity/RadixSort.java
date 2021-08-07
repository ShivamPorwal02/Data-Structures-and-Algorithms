package TimeandSpaceComplexity;
import java.util.Scanner;
public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int dgt = 0;
        while (max > 0) {
            dgt++;
            max = max / 10;
        }
        for (int i = 1; i <= dgt; i++) {
            countSort(arr, (int) Math.pow(10, i - 1));
        }
    }

    public static void countSort(int[] arr, int exp) {
        int[] farr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] / exp;
            int idx = num % 10;
            farr[idx]++;
        }
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] / exp;
            int idx1 = num % 10;
            int pos = farr[idx1];
            int idx = pos - 1;
            ans[idx] = arr[i];
            farr[idx1]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }
}
