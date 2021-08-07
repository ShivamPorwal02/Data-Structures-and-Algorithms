package LoveBabbar.DynamicProgramming;

public class isSubsequence {
    boolean isSubSequence(String A, String B){
        int j = 0;
        for(int i=0;i<B.length() && j<A.length();i++){
            if(B.charAt(i)==A.charAt(j)) j++;
        }

        return j==A.length();
    }
}
