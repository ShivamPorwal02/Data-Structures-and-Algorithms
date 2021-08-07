import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=n;j>i;j--){
                System.out.print("\t");
            }
            for (int k=i;k>=1 ;k-- ) {
                System.out.print(k+"\t");
            }
            System.out.println();
        }
    }
}

