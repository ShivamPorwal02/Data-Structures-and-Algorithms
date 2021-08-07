package LoveBabbar.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;

public class ValueEqualToIndexValue {
    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        // code here
        int start  = 0;
        int end = arr.length-1;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> lst = new ArrayList<>();
        while(start<=end){
            int mid = (start+end)/2;
            if(mid==arr[mid]){
                lst.add(arr[mid]);
                return lst;
            }else if(arr[mid]>mid){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return lst;

        // binary search tbhi use hoga agr array sorted hai vrna o(n) wale method prr chle jaana

    }
}
