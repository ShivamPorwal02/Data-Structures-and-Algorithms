package LoveBabbar.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int target) {
        int[] arr = new int[9];
        for(int i=0;i<9;i++) arr[i] = i+1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        recursion(0,ans,arr,lst,target,k);

        return ans;
    }
    static void recursion(int idx,List<List<Integer>> ans,int[] arr,List<Integer> lst,int total,int k){
        if(idx==arr.length){
            if(total==0 && lst.size()==k){
                List<Integer> lst1 = new ArrayList<>(lst);
                Collections.sort(lst1);
                if(!ans.contains(lst1)) ans.add(new ArrayList<>(lst1));
            }
            return;
        }
        if(total<0) return;

        if(arr[idx]<=total){
            lst.add(arr[idx]);
            recursion(idx+1,ans,arr,lst,total-arr[idx],k);
            lst.remove(lst.size()-1);
        }
        recursion(idx+1,ans,arr,lst,total,k);
    }
}
