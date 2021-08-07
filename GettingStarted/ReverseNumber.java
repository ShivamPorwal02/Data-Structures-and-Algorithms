import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int temp=n;
        int ans=0;
        int cnt=0;
        while(n!=0){

            n=n/10;
            cnt++;
        }
        int x = (int)Math.pow(10,cnt-1);
        while(temp!=0){
            ans=ans+(temp%10)*x;
            x=x/10;
            temp=temp/10;
        }
        System.out.println(ans);
    }
}

