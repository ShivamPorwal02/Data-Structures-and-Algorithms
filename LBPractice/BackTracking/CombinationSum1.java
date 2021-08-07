package LoveBabbar.BackTracking;

import java.util.*;

public class CombinationSum1 {
    // isse TLE ni aaega
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int total)
    {
        // add your code here
        ArrayList<ArrayList<Integer> > ans
                = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        // first do hashing since hashset does not always
        // sort
        //  removing the duplicates using HashSet and
        // Sorting the arrayList

        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);

        findNumbers(ans, arr, total, 0, temp);
        return ans;
    }
    static void
    findNumbers(ArrayList<ArrayList<Integer> > ans,
                ArrayList<Integer> arr, int sum, int index,
                ArrayList<Integer> temp)
    {

        if (sum == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.size(); i++) {

            if ((sum - arr.get(i)) >= 0) {
                temp.add(arr.get(i));

                findNumbers(ans, arr, sum - arr.get(i), i,
                        temp);
                temp.remove(arr.get(i));
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        recursion(0,ans,arr,lst,target);
        return ans;
    }
    static void recursion(int idx,List<List<Integer>> ans,int[] arr,List<Integer> lst,int total){
        if(idx==arr.length){
            if(total==0){
                ans.add(new ArrayList<>(lst));
            }
            return;
        }
        if(total<0) return;
        if(arr[idx]<=total){
            lst.add(arr[idx]);
            recursion(idx,ans,arr,lst,total-arr[idx]);
            lst.remove(lst.size()-1);
        }
        recursion(idx+1,ans,arr,lst,total);
    }
}
