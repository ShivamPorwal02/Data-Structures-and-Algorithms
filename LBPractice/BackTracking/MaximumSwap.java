package LoveBabbar.BackTracking;

public class MaximumSwap {
    // pepcoding wali hai iski ek video vo dekhlena
    static String max;
    public int maximumSwap(int num) {
        String str = num +"";
        char[] arr = str.toCharArray();
        int[] li = new int[10];
        for(int i=0;i<str.length();i++){
            int digit = arr[i]-'0';
            li[digit] = i;
        }
        boolean flag = false;
        for(int i=0;i<str.length();i++){
            int digit = arr[i]-'0';
            for(int j=9;j>digit;j--){
                if(i<li[j]){
                    swap(arr,i,li[j]);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        String res = "";
        for(int i=0;i<arr.length;i++){
            res+=arr[i];
        }
        return Integer.parseInt(res);
    }
    public static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
