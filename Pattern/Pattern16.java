import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int spc= 2*n-2;
        int str=1;
        for(int i =1 ;i<=n;i++){
            for (int j=1;j<=i ;j++ ) {
                System.out.print(j+"\t");
            }
            for (int j=1;j<spc ;j++ ) {
                System.out.print("\t");
            }
            for (int j=i;j>0 ;j-- ) {
                if(i==j && i==n){
                    continue;
                }
                else{
                System.out.print(j+"\t");
            }
            }
            System.out.println();
            str+=1;
            spc-=2;
        }
    }
}
