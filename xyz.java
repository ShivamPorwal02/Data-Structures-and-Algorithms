import java.util.Arrays;
import java.util.Scanner;

public class xyz {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        String s1 = scn.nextLine();
        String[] arr = s1.split(",");
        int[] a = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            a[i] = Integer.parseInt(arr[i]);
        }
        String s = "";

        for(int i=0;i<a.length;i=i+n){

            boolean flag = false;
            for(int j=i;j<i+n;j++){
                if(a[j]%10==0){
                    flag = true;
                    s+=(char)((a[j]/10)+64);
                    break;
                }
            }
            if(flag==false){
                if(s.equals("")){
                    s+="-";
                }else{
                    s+=s.charAt(s.length()-1);
                }
            }
        }
        System.out.println(s);
    }

}
