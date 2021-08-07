package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class SmallestFactorialNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = smallestNumber(n);
        System.out.println(ans);
    }
    public static int smallestNumber(int n) {
        // Complete this function
        int low = 0;
        int high = 5 * n;
        int best = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (trailingZeroes(mid) > n) {
                best = mid; // yha prr islia kyuki ussn "atleast" bola hai to agr same zeros ni mile to thoda upr wla bhi chl jaaega
                high = mid - 1;
            } else if (trailingZeroes(mid) < n)
                low = mid + 1;
            else {
                best = mid;
                high = mid - 1;
            }
        }
        return best;
    }
    public static int trailingZeroes(int n) {

        int num = 5;
        int cnt = 0;
        while(num<=n){
            cnt+=(n/num);
            num*=5;
        }
        return cnt;
    }
}
