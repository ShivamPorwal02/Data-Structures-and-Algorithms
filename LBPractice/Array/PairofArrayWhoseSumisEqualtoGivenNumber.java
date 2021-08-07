package LoveBabbar;

public class PairofArrayWhoseSumisEqualtoGivenNumber {
    int getPairsCount(int[] arr, int n, int sum) {
        // code here
        int cnt = 0;
        int[] temp = new int[sum+1];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=sum){
                temp[arr[i]]++;
            }
        }
        // System.out.println(Arrays.toString(temp));

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for(int i=0;i<arr.length;i++) {
            if (arr[i] <= sum) {
                cnt += temp[sum - arr[i]];
            }
            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (sum - arr[i] == arr[i])
                cnt--;
        }
        return cnt/2;
    }
}
