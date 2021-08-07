package RecursionAV;

import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int ans = LastPerson(n,k);
//        System.out.println(ans);
    }
    public static int LastPerson(int n,int k){
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=1;i<=n;i++){
            lst.add(i);
        }
//        System.out.println(lst);
        k--;
//        System.out.println(k);
        int ans = -1;
        int index = 0;
        LastAlive(lst,k,index,ans);
        return ans;
    }
    public static void LastAlive(ArrayList<Integer> lst,int k,int index,int ans){
        if(lst.size()==1){
            ans = lst.get(0);
            System.out.println(ans);
            return;
        }
        index = (index+k)%lst.size();
        lst.remove(index);
        LastAlive(lst,k,index,ans);
//        return;
    }
}
