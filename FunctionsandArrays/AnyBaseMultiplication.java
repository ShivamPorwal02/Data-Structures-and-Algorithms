import java.awt.event.MouseAdapter;
import java.net.MalformedURLException;
import java.util.Scanner;

public class AnyBaseMultiplication {
    public static int addition(int b,int n1,int n2){

        int sum=0;
        int i=0;
        int carry = 0;
        while(n1>0 || n2>0 || carry>0){
            int a = n1%10;
            int c = n2%10;
            int d= a+c+carry;
            carry=d/b;
            d=d%b;
            sum+=d*Math.pow(10,i);
            i++;
            n1=n1/10;
            n2=n2/10;
        }
//        sum+=carry*Math.pow(10,i);
        return sum;
    }
//    public static int mul(int b,int n1,int n2){
//        int carry=0;
//        int i=0;
//        int ans = 0;
//        while (n1>0 || carry>0){
//            int a = n1%10;
//            int x = addition(b,a*n2,carry);
//            int d = x%b;
////            int y = d%b;
//            carry=x/b;
//            ans+=(d* Math.pow(10,i));
//            n1=n1/10;
//            i++;
//        }
//        return ans;
//    }
    public static int multiplication(int b,int n1,int n2){
        int rv=0;
        int p=1;
        while (n2>0 ){
            int d2 = n2%10;
            n2=n2/10;
            int sprd = MulBySingleDigit(b,n1,d2);
            rv =addition(b,rv,sprd*p);
            p=p*10;
        }
        return rv;
    }
    public static int MulBySingleDigit(int b,int n1,int d2){
        int rv=0;
        int i=0;
        int carry=0;
        while(n1>0 || carry>0){
            int d1 = n1%10;
            n1=n1/10;
            int d = d1*d2+carry;
            carry=d/b;
            d=d%b;
            rv+=(d*Math.pow(10,i));
            i++;
        }
        return rv;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int sum = multiplication(b,n1,n2);
        System.out.println(sum);
    }
}
