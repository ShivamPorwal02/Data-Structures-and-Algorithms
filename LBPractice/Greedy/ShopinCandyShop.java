package LoveBabbar.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class ShopinCandyShop {
    static ArrayList<Integer> candyStore(int arr[], int N, int k){
        // code here
        ArrayList<Integer> lst = new ArrayList<>();
        Arrays.sort(arr);
        int i=0;
        int j = arr.length-1;
        int ans = 0;
        while(i<=j){
            ans+=arr[i];
            int idx = k;
            while(idx!=0){
                j--;
                idx--;
            }
            i++;
        }
        lst.add(ans);
        ans = 0;
        i = arr.length-1;
        j = 0;

        while(j<=i){
            ans+=arr[i];
            int idx = k;
            while(idx!=0){
                j++;
                idx--;
            }
            i--;
        }
        lst.add(ans);
        return lst;
    }
}
