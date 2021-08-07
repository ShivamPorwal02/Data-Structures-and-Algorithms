import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int str=1;
        int spc1=n/2;
        int spc2=0;
        for (int i=1;i<=n ;i++ ) {
            for (int j=1;j<=spc1 ;j++ ) {
                System.out.print("\t");
            }
            System.out.print("*");
            for (int j=1;j<=spc2 ;j++ ) {
                System.out.print("\t");
            }
            if(spc2!=0) {
                System.out.print("*");
            }
            if(i<=n/2){
                spc1--;
                spc2+=2;
            }
            else {
                spc1++;
                spc2-=2;
            }
            System.out.println();
        }
    }
}
