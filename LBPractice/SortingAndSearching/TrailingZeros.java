package LoveBabbar.SortingAndSearching;

public class TrailingZeros {
    public int trailingZeroes(int n) {
        // just 5*2 k pair 10 mtlb ek zero denge to hm bss 5 k count krr lete hai
        // 5 25 25*5 ese hi divide krte jaanege jitne baar divide honge utne 5 dere hai
        int num = 5;
        int cnt = 0;
        while(num<=n){
            cnt+=(n/num);
            num*=5;
        }
        return cnt;
    }
}
