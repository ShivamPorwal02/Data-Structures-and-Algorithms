package LoveBabbar.StackandQueues;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here

        // here we have used an additional hashmap niche wale m hmne bina isk hi krdia

        Stack<Long> st = new Stack<>();
        HashMap<Long,Long> hm = new HashMap<>();

        st.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(st.size()>0 && st.peek()<arr[i]){
                hm.put(st.pop(),arr[i]);
                while(st.size()>0 && st.peek()<arr[i]){
                    hm.put(st.pop(),arr[i]);
                }
                st.push(arr[i]);
            }else{
                st.push(arr[i]);
            }
        }

        while(st.size()!=0){
            hm.put(st.pop(),(long)-1);
        }
        long[] ans = new long[n];

        for(int i = 0; i < arr.length; i++){
            ans[i] = hm.get(arr[i]);
        }
        return ans;
    }
    public static long[] nextLargerElement_(long[] arr, int n)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[n];

        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]<arr[i]){
                ans[st.pop()] = arr[i];
            }
            st.push(i);

        }

        while(st.size()!=0){
            ans[st.pop()] = -1;
        }

        return ans;
    }
}
