package LoveBabbar;

public class _4a_UnionofTwoArrays {
    public static int doUnion(int a[], int n, int b[], int m)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        for(int i=0;i<b.length;i++){
            if(b[i]>max){
                max = b[i];
            }
        }
        int[] table = new int[max+1];
        int cnt=0;
        int i=0;
        while(i<a.length){
            if(table[a[i]]==0){
                cnt++;
                table[a[i]]++;
            }
            i++;
        }
        int j=0;
        while(j<b.length){
            if(table[b[j]]==0){
                cnt++;
                table[b[j]]++;
            }
            j++;
        }
        return cnt;
    }
}
