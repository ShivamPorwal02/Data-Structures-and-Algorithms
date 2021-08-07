package LoveBabbar.DynamicProgramming;

public class MaximumDifferenceof0and1inbinaryString {
    int maxSubstring(String s) {
        // code here
        int res =0;
        int max = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(res>0) res+=1;
                else res = 1;
            }else{
                res-=1;
            }
            if(res>max) max = res;
        }
        return max;
    }
}
