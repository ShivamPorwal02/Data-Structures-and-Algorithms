import java.util.Scanner;

public class Pattern18 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int spc=n/2-1;
        int str=3;
        for (int i=1;i<=n ;i++ ) {
            if(i<=n/2+1) {
                for (int j=1;j<=n ;j++ ) {
                    if(i+j==n+1 || i==1 || i==j){
                        System.out.print("*\t");
                    }
                    else {
                        System.out.print("\t");
                    }
                }
            }
            else{
                for (int j=1;j<=spc ;j++ ) {
                    System.out.print("\t");
                }
                for (int j=1;j<=str ;j++ ) {
                    System.out.print("*\t");
                }
                str+=2;
                spc--;
            }
            System.out.println();
        }
    }
}
