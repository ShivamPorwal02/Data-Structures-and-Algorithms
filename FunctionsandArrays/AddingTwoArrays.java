import java.util.Scanner;

public class AddingTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a =new int[n1];
        for (int i=0;i<a.length ;i++ ) {
            a[i]=scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] b = new int[n2];
        for (int i=0;i<b.length ;i++ ) {
            b[i]=scn.nextInt();
        }
        int[] sum = new int[n1>n2?n1:n2];
        int i = a.length-1;
        int j = b.length-1;
        int k = sum.length-1;
        int carry = 0;
        while (k>=0){
            int d = carry;
            if(i>=0){
                d+=a[i];
                i--;
            }
            if(j>=0){
                d+=b[j];
                j--;
            }
            carry=d/10;
            d=d%10;
            sum[k]=d;
            k--;
        }
        if(carry>0){
            System.out.println(carry);
        }
        for (i=0;i<sum.length ;i++ ) {
            System.out.println(sum[i]);
        }

    }
}
