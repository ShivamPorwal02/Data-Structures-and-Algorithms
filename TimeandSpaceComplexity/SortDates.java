package TimeandSpaceComplexity;
import java.util.Scanner;

public class SortDates {
    public static void sortDates(String[] arr) {
        // year ka precedence jyda hota hai islia hm use last m lere hai
        countSort(arr,1000000,100,32);
        countSort(arr,10000,100,13);
        countSort(arr,1,10000,2501);
    }

    // Java 056 ko octal m read krta hai islia hm Integer.parseInt m 10 daalna pdra hai

    public static void countSort(String[] arr, int div,int mod,int range) {
        int[] farr = new int[range];

        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i],10) / div;
            int idx = num % mod;
            farr[idx]++;
        }
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }
        String[] ans = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = Integer.parseInt(arr[i],10) / div;
            int idx1 = num % mod;
            int pos = farr[idx1];
            int idx = pos - 1;
            ans[idx] = arr[i];
            farr[idx1]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }

}
