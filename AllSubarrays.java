import java.util.Scanner;

public class AllSubarrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<a.length ;i++ ) {
            a[i]=scn.nextInt();
        }
        for (int i=0;i<a.length ;i++ ) {
//            int j=0;
//            while(j!=a.length){
//                int flag=0;
//                for (int k=i;k<=j ;k++ ) {
//                    System.out.print(a[k]+" ");
//                    flag=1;
//                }
//                if(flag!=0) {
//                    System.out.println();
//                }
//                j++;
//            }
            for (int j=i;j<a.length ;j++ ) {
                for (int k=i;k<=j ;k++ ) {
                    System.out.print(a[k]+" ");
                }
                System.out.println();
            }
        }
    }
}
