package LoveBabbar.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MinimumCostToCutaBoardIntoSquares {
    public static void main(String arg[])
    {
        int m = 6, n = 4;
        Integer X[] = {2, 1, 3, 1, 4};
        Integer Y[] = {4, 1, 2};
        System.out.print(minimumCostOfBreaking(X, Y, m-1, n-1));
    }
    public static int minimumCostOfBreaking(Integer[] arr1,Integer[] arr2,int m,int n){
        int res = 0;

        Arrays.sort(arr1, Collections.reverseOrder());
        Arrays.sort(arr2, Collections.reverseOrder());

        int i = 0;
        int j = 0;
        int hori =1;
        int vert = 1;

        while(i<m && j<n){
            if(arr1[i]>arr2[j]){
                res+=(arr1[i]*vert);
                hori++;
                i++;
            }else{
                res+=(arr2[j]*hori);
                vert++;
                j++;
            }
        }

        while(i<m){
            res+=(arr1[i]*vert);
            hori++;
            i++;
        }
        while (j<n){
            res+=(arr2[j]*hori);
            vert++;
            j++;
        }
        return res;
    }
}
