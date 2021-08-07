import java.util.Scanner;

public class FirstIndexLastIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n  = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<a.length ;i++ ) {
            a[i]=scn.nextInt();
        }
        int key = scn.nextInt();
        int l=0;
        int h=a.length-1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(l<=h){
            int m = (l+h)/2;
            if(key>a[m]){
                l=m+1;
            }else if(key<a[m]){
                h=m-1;
            }
            else {
                max=m;
                h=m-1;
            }
        }
        System.out.println(max==Integer.MIN_VALUE?-1:max);
        l=0;
        h=a.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(key>a[m]){
                l=m+1;
            }else if(key<a[m]){
                h=m-1;
            }
            else {
                min=m;
                l=m+1;
            }
        }
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }
}
