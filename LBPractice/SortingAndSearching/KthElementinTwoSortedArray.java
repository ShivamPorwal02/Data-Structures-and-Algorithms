package LoveBabbar.SortingAndSearching;

public class KthElementinTwoSortedArray {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {

        // time complexity --> O(k) and Space complexity --> O(1);
        int i=0;
        int j = 0 ;
        int cnt = 0 ;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                cnt++;
                if(cnt==k){
                    return arr1[i];
                }
                i++;
            }else{
                cnt++;
                if(cnt==k){
                    return arr2[j];
                }
                j++;
            }
        }
        while(i<arr1.length){
            cnt++;
            if(cnt==k){
                return arr1[i];
            }
            i++;
        }
        while(i<arr2.length){
            cnt++;
            if(cnt==k){
                return arr2[j];
            }
            j++;
        }
        return -1;
    }
}
