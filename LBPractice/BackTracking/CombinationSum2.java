package LoveBabbar.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        recursion(0,ans,arr,lst,target);

        return ans;
    }
    static void recursion(int idx,List<List<Integer>> ans,int[] arr,List<Integer> lst,int total){
        if(idx==arr.length){
            if(total==0){
                List<Integer> lst1 = new ArrayList<>(lst);
                Collections.sort(lst1);
                if(!ans.contains(lst1)) ans.add(new ArrayList<>(lst1));
            }
            return;
        }
        if(total<0) return;

        if(arr[idx]<=total){
            lst.add(arr[idx]);
            recursion(idx+1,ans,arr,lst,total-arr[idx]);
            lst.remove(lst.size()-1);
        }
        recursion(idx+1,ans,arr,lst,total);
    }
}
