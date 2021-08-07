import java.util.Scanner;

public class BrokenEconomy {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<a.length ;i++ ) {
            a[i]=scn.nextInt();
        }
        int key = scn.nextInt();
        int l=0;
        int h=a.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(key>a[m]){
                l=m+1;
            }else if(key<a[m]){
                h=m-1;
            }
            else {
                System.out.println(m);
                return;
            }
        }
        System.out.println(a[l]);
        System.out.println(a[h]);
    }
}
