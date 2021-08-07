import java.util.Scanner;

public class AnyBaseToDecimal {
    public static int anybasetodec(int n,int k){
        int ans = 0;
        int i=0;
        while (n!=0){
            int a = n%10;
            ans+=a*((int)Math.pow(k,i));
            i++;
            n=n/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int val=anybasetodec(n,k);
        System.out.println(val);
    }
}
