import java.util.Scanner;

public class RotateNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int temp = n;
        int k = scn.nextInt();
        int cnt = 0;
        while (n != 0) {
            n = n / 10;
            cnt++;
        }
        int x = (int) Math.pow(10, cnt);
        if (k > 0 && k<=cnt) {
            while (k != 0) {
                temp = temp + x * (temp % 10);
                temp = temp / 10;
                k = k - 1;
            }
            System.out.println(temp);
        }
        else if(k<=0 && k<=cnt){
            int div = x/10;
            while (k != 0) {
                int y = temp/div;
                temp = (temp * 10 )+y;
                temp = temp % x;
                k = k + 1;
            }
            System.out.println(temp);
        }
        else{
            k= k%cnt;
            while (k != 0) {
                temp = temp + x * (temp % 10);
                temp = temp / 10;
                k = k - 1;
            }
            System.out.println(temp);

        }
    }

}
