package LoveBabbar.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

public class LIS_NlogN {

    // qn:= but how 6 can come before 8 if it is subsequence, we cannot change the order of elements. am I wrong?
    //See here 6 doesn't come before 8.What happens is that lets suppose you have a LIS upto a particular index .Now you encountered an element which is greater than the rightmost element.We will obviously take it to increase our length of LIS.Now if the new element is smaller,we can't increase the length of our lis .But what we can do is that find the element just greater than it in the lis and replace it with the new element .This ensures that upto that index we can have an lis.And it will help when future values come.
    //1 2 4 5 3 4 5.In this case
    //1 2 4 5-upto this it's obvious .now 3 is less than 5 so what we can do is that we can replace 4 with 3 ,it doesn't mean that the lis is 1 2 3 5,it's still 1 2 4 5 but we get a smaller lis of 1 2 3 .Now when 4 comes again 4<5 so we cant't increase our lis ,but we can create a new lis upto 4 which is 1 2 3 4 now when 5 comes we can increase our lis and finally length is 5.We are storing the min because it helps to update future values .
    //I myself struggled to understand it a few months back,but with experience things become clear.Hope it helps🙂

    static int longestSubsequence(int size, int arr[])
    {
        // code here
        ArrayList<Integer> lst = new ArrayList<>();

        lst.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(lst.get(lst.size()-1) < arr[i]) lst.add(arr[i]);
            else{
                int idx = Collections.binarySearch(lst,arr[i]);
                if(idx<0) idx = -(idx) -1;
                lst.set(idx,arr[i]);
            }
        }
        return lst.size();
    }
}
