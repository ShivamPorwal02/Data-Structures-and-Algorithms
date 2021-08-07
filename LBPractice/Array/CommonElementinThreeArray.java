package LoveBabbar;

import java.util.ArrayList;

public class CommonElementinThreeArray {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        // code here
        ArrayList<Integer> lst = new ArrayList<>();
        int i=0;
        int j=0;
        int k = 0;
        while(i<A.length && j<B.length && k < C.length){
            if(A[i]==B[j] && B[j]==C[k]){
                lst.add(A[i]);
            }else if(A[i]>=B[j] && A[i]>=C[k]){
                j++;
                k++;
            }else if(A[i]<=B[j] && B[j]>=C[k]){
                i++;
                k++;
            }else if(C[k]>=B[j] && A[i]<=C[k]){
                i++;
                j++;
            }
        }
        return lst;
    }
}
