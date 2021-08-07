import java.util.Scanner;

public class DigitFrequency {
    public static int digitfreq(int n,int k){
        int nod = 0;
        while(n!=0){
            int a=n%10;
            if(a==k){
                nod++;
            }
            n=n/10;
        }
        return nod;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int ans = digitfreq(n,k);
        System.out.println(ans);
    }
}
