package LoveBabbar.Greedy;

public class MaximumSumDifference {
    // https://www.geeksforgeeks.org/maximum-sum-difference-adjacent-elements/

    // ye imp hai ki last wla agr phle rkhdo to jyda sum aane lgta hai nice qn though
    static int maxSum(int n){
        // code here
        if(n==1) return 1;
        return n*(n-1)/2 -1 + n/2;

    }
}
