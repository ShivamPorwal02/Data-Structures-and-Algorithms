package LoveBabbar;

import java.util.Arrays;

public class TripletSuminArray {
    public static boolean find3Numbers(int A[], int n, int X) {
        Arrays.sort(A);
        // Your code Here

        for(int i=0;i<A.length;i++){
            int tofind = X-A[i];
            int j=i+1;
            int k = A.length-1;
            while(j<k){
                if(A[j]+A[k]==tofind){
                    return true;
                }else if(A[j]+A[k]>tofind){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return false;

    }
}
