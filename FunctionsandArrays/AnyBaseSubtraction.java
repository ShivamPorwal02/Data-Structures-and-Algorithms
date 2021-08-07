import java.util.Scanner;

public class AnyBaseSubtraction {
    public static int sub(int b,int n1,int n2){
        int rv= 0;
        int borrow = 0;
        int i=0;
        while(n2>0){
            int d2=n2%10;
            int d1=n1%10;
            int d = 0;
            d2=d2+borrow;
            if(d2>=d1){
                borrow=0;
                d=d2-d1;
            }else {
                borrow=-1;
                d=d2+b-d1;
            }
            rv+=(d*Math.pow(10,i));
            i++;
            n1=n1/10;
            n2=n2/10;
        }
        return rv;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int sum = sub(b,n1,n2);
        System.out.println(sum);
    }
}
