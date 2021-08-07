package LoveBabbar.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class EqualSubsetSum {
    List<Integer> lst1 = new ArrayList<>();
    List<Integer> lst2 = new ArrayList<>();
     public boolean findSets(int[] arr,int sum1,int sum2,int pos){
        if(pos==arr.length){
            if(sum1==sum2){
                return true;
            }else return false;
        }
        lst1.add(arr[pos]);
        boolean res = findSets(arr,sum1+arr[pos],sum2,pos+1);
        if(res==true) return true;

        lst1.remove(lst1.size()-1);
        lst2.add(arr[pos]);

        res = findSets(arr,sum1,sum2+arr[pos],pos+1);
        if(res==false){
            if(lst2.size()>0) lst2.remove(lst2.size()-1);
        }
        return res;
    }
}
