package LoveBabbar.Strings;

import java.util.Stack;

public class LargestAreainHistogram {
    public int largestRectangleArea(int[] arr) {
        if(arr.length==1){
            return arr[0];
        }
        int[] rb = new int[arr.length];  // next smaller element in right
        Stack<Integer> st = new Stack<>();
        rb[arr.length-1] = arr.length;
        st.push(arr.length-1);

        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                rb[i] = arr.length;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }

        int[] lb = new int[arr.length];  // next smaller element in left
        st = new Stack<>();
        lb[0] = -1;
        st.push(0);

        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }
        int maxArea = 0;
        for(int i=0;i<arr.length;i++){
            int width = rb[i]-lb[i]-1;
            int area = arr[i] * width;
            if(area>maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
