import java.util.ArrayList;
import java.util.Scanner;

public class RemovesPrimesinArrayList {
    public static boolean isPrime(int n){
        for (int j=2;j*j<=n ;j++ ) {
            if(n%j==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
            list.add(scn.nextInt());
        }
        // ulta islia chlaya hai kyuki agr seedha chlate to index ka scene pdta hai
        for (int i=list.size()-1;i>=0 ;i-- ) {
            int val = list.get(i);
            if(isPrime(val)){
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
