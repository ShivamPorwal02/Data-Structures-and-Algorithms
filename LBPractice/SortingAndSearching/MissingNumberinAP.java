package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class MissingNumberinAP {
    // O(logN) m hai
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int ans = findmissing(arr);
        System.out.println(ans);
    }
    public static int missingNumber(int[] arr,int diff){
        int  i =0;
        int j = arr.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid+1]-arr[mid] != diff){
                return arr[mid] + diff;
            }else if(mid>0 && arr[mid]-arr[mid-1]!=diff){
                    return arr[mid-1]+diff;
            }else if( arr[mid] == arr[0]+mid*diff){  // must be thinking ki mid se kuu multiply kia
                // islia kuu 0 index hai to apne aapa a(n-1)+d bnn jaaega bina minus kia
                i=mid+1;
            }else{
                j = mid-1;
            }
        }
        return -1;
    }
    public static int findmissing(int[] arr){
        int diff = (arr[arr.length-1]-arr[0])/arr.length;
        // dekho ye kaise aya
        // last element an = a(n-1)+d
        // kyuki yaha prr ek element gyb hai to eg agr hme 6 elements de rkhi hai but ek missing hai to 7 hai
        //  to last element ye hoga agr ap puri hai to --> a(7-1=6)+d && first element --> a
        // therefore d = (a(last)-a(first)/n)
        // i hope u got it
        return missingNumber(arr,diff);
    }
}

