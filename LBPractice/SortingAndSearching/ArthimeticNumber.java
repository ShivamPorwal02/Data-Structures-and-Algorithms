package LoveBabbar.SortingAndSearching;

public class ArthimeticNumber {
    static int inSequence(int A, int B, int C){
        // code here
        if(A==B){
            return  1;
        }
        double x = (double)(B-A)/C;
        if(x<=0){
            return 0;
        }
        int y = (int)Math.floor(x);
        return x==y ? 1 : 0;
    }
}
