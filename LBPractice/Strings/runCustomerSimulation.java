package LoveBabbar.Strings;

import java.util.HashMap;
import java.util.Scanner;

public class runCustomerSimulation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String s = scn.next();
        int ans =runCustSimulation(n,s);
        System.out.println(ans);
    }
    public static int runCustSimulation(int n,String s){
        HashMap<Character,Boolean> hm = new HashMap<>();
        int occ = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                if(hm.get(s.charAt(i))) {
                    hm.put(s.charAt(i), false);
                    occ--;
                }else{
                    hm.put(s.charAt(i),false);
                }
            }else{
                if(occ>=n){
                    ans+=1;
                    hm.put(s.charAt(i),false);
                }else{
                    hm.put(s.charAt(i),true);
                    occ++;
                }
            }
        }
        return ans;
    }
}
