import java.util.Scanner;

public class AnyBaseToAnyBase {
//    public static int anytonay(int n,int b1,int b2){
//        int ans = 0;
//        int i=0;
//        while (n!=0){
//            int a = n%b2;
//            ans+=a*((int)Math.pow(b1,i));
//            i++;
//            n=n/b2;
//        }
//        return ans;
//    }
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
        int a = scn.nextInt();
        int b = scn.nextInt();
        int val=anybasetodec(n,a);
        int val2 = DecToAnyBase(val,b);
        System.out.println(val2);
    }
}
