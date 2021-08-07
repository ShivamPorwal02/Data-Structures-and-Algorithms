import java.util.Scanner;

public class IsNumberPrime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        while (n!=0){
            int m = scn.nextInt();
            int flag=0;
            for(int i=2;i<=m/2;i++){
                if(m%i==0){
                    System.out.println("not prime");
                flag=1;
                break;
                }
            }
            if(flag==0){
                System.out.println("prime");
            }
            n=n-1;
        }
    }
}
