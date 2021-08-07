import java.util.Scanner;

public class DecimalToAnyBase {
    public static int DecToAnyBase(int n, int k){
        int ans = 0;
        int i=0;
        while (n!=0){
            int a = n%k;
            ans+=a*((int)Math.pow(10,i));
            i++;
            n=n/k;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int val=DecToAnyBase(n,k);
        System.out.println(val);
    }
}
