package RecursionAV;
import java.util.*;
public class SortAnArray {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0;i<n;i++){
            lst.add(scn.nextInt());
        }
       Sort(lst);
        System.out.println(lst);
    }
    // hypothesis :- ki hme sort krk dega
    public static void Sort(ArrayList<Integer> lst){
        // base
        if(lst.size()==1){
            return;
        }
        // induction

        int val = lst.remove(lst.size()-1);
        Sort(lst);
        insert(lst,val);
    }
    public static void insert(ArrayList<Integer> lst,int temp){
        if(lst.size()==0 || lst.get(lst.size()-1)<=temp){
            lst.add(temp);
            return;
        }
        int val = lst.remove(lst.size()-1);
        insert(lst,temp);
        lst.add(val);
        return;
    }

}
