import java.util.Scanner;

public class GCDandLCM {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b= scn.nextInt();
        int gcd = 0;
        if(a>b){
            for(int i =1;i<=b;i++){
                if(a%i==0 && b%i==0){
                    gcd= i;
                }
            }
        }
        else{
            for (int i=1;i<=a ;i++ ) {
                if(a%i==0 && b%i==0){
                    gcd= i;
                }
            }
        }
        System.out.println(gcd);
        System.out.println((a*b)/gcd);
    }
}
