import java.util.Scanner;

public class DifferenceOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a = new int[n1];
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] b = new int[n2];
        for (int i = 0; i < b.length; i++) {
            b[i] = scn.nextInt();
        }
        int[] sum1 = new int[n2>n1?n2:n1];
        int i = a.length - 1;
        int j = b.length - 1;
        int k = sum1.length - 1;
        int borrow = 0;
        int av=0;
        while (k>= 0) {
            if(i<0){
                 av=0;
            }
            else{
                av=a[i];
            }
            if (b[j]+borrow >= av) {
                sum1[k] = b[j] - av +borrow;
                borrow = 0;
            } else {
//                System.out.println(k);
                sum1[k] = b[j]+10 - av + borrow;
                borrow = -1;
            }
            i--;
            j--;
            k--;
        }
        int idx=0;
        while(idx<sum1.length){
            if(sum1[idx]==0){
                idx++;
            }
            else {
                break;
            }
        }
        while(idx<sum1.length){
            System.out.println(sum1[idx]);
            idx++;
        }
    }
}
