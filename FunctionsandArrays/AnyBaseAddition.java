import java.util.Scanner;

public class AnyBaseAddition {
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
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int sum = addition(b,n1,n2);
        System.out.println(sum);
    }
}
