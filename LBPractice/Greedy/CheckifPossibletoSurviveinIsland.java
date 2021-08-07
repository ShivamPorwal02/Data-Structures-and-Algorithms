package LoveBabbar.Greedy;

public class CheckifPossibletoSurviveinIsland {
    static int minimumDays(int s, int n, int m){
        // code here
        if(6*n < 7*m && s > 6||m>n) return -1;

        return (int)Math.ceil((double)(s*m)/(double)(n));
    }
}
