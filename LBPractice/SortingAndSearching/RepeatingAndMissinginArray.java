package LoveBabbar.SortingAndSearching;

public class RepeatingAndMissinginArray {
    int[] findTwoElement(int arr[], int n) {
        // WITHOUT EXTRA SPACE HAI
        // code here
        int[] ans = new int[2];
        // int[] array = new int[n+1];
        for(int i=0;i<arr.length;i++){
            if(arr[Math.abs(arr[i])-1]>0){
                arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
            }else{
                ans[0] = Math.abs(arr[i]);
            }
        }
        // int[] ans = new int[2];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                ans[1] = i+1;
            }
        }
        return ans;
    }
}
