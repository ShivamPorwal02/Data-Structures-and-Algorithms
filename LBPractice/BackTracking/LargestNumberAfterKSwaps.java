package LoveBabbar.BackTracking;

public class LargestNumberAfterKSwaps {
    // giving TLE
    static String max;
    public static String findMaximumNum(String str, int k)
    {
        //code here.
        max = "";
        findMaximum(str,k);
        return max;
    }
    public static void findMaximum(String str,int k){

        if(max=="") max = str;

        java.math.BigInteger a = new java.math.BigInteger(str);
        java.math.BigInteger b = new java.math.BigInteger(max);
        if(a.compareTo(b)>0) max = str;

        if(k==0) return;

        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(j)>str.charAt(i)){
                    str = swap(str,i,j);
                    findMaximum(str,k-1);
                    str = swap(str,i,j);
                }
            }
        }
    }
    public static String swap(String str,int i,int j){
        String left = str.substring(0,i);
        String middle = str.substring(i+1,j);
        String ith = str.charAt(i)+"";
        String right = str.substring(j+1);
        String jth = str.charAt(j)+"";
        str = left+jth+middle+ith+right;
        return str;
    }
}
