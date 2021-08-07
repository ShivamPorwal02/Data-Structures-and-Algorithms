package LoveBabbar.SortingAndSearching;

public class MaximumSumofNonAdjacentElement {
    public int FindMaxSum(int a[], int n)
    {
        // Your code here
        int inc = a[0];
        int exc = 0;
        for(int i=1;i<a.length;i++){
            int ninc = exc+a[i];
            int nexc = Math.max(inc,exc);

            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc,exc);
    }
}
