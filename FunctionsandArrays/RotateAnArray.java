import java.util.Scanner;

public class RotateAnArray {
    public static void reverse(int[] a,int l,int h){
        while(l<h){
            int temp=a[l];
            a[l]=a[h];
            a[h]=temp;
            l++;
            h--;
        }
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int k = scn.nextInt();
//        if (k > 0) {
//            int x = a.length - 1;
//            int j = 0;
//            while (k != 0) {
//                int temp = a[x];
//                for (int i = a.length - 1; i>=1; i--) {
//                    a[i] = a[i-1];
//                }
//                a[j] = temp;
//                k--;
//            }
//        }else{
//            int j = a.length - 1;
//            int x = 0;
//            while (k != 0) {
//                int temp = a[x];
//                for (int i =1; i<=a.length-1; i++) {
//                    a[i-1] = a[i];
//                }
//                a[j] = temp;
//                k++;
//            }
//        }

        // OPTIMAL SOLUTION //
        k=k%a.length;
        if(k<0){
            k=k+a.length;
        }
        //Part1
        reverse(a,0,a.length-k-1);
        //Part2
        reverse(a,a.length-k,a.length-1);
        //Whole Part
        reverse(a,0,a.length-1);















        for (int val : a) {
            System.out.print(val + " ");
        }
    }
}
