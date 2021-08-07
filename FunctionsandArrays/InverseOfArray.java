import java.util.Scanner;

public class InverseOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]=scn.nextInt();
        }
        int[] b = new int[n];
        for (int i=0;i<a.length ;i++ ) {
            b[a[i]]=i;
        }
        for(int i=0;i<a.length;i++){
            a[i]=b[i];
        }
        for(int val:a){
            System.out.println(val);
        }
    }
}
