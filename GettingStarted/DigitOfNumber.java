import java.util.Scanner;

public class DigitOfNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int num=1;
        int temp=n;
        while(temp!=0){
            temp=temp/10;
            num=num*10;
        }
        int div=num/10;
        while (num!=0){
            System.out.println((n/div));
            n=n%div;
            div=div/10;
        }
    }
}
