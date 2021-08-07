package LeetCode;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] arr) {
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=min) min = arr[i];
            else if(arr[i]<smin) smin = arr[i];
            else if(arr[i]>smin) return true;
        }
        return false;
    }
}
