package LoveBabbar.Strings;

import java.util.Stack;

public class MaximumSizeRectangleinMatrix {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int max = 0 ;
        int[] arr = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    arr[j] = arr[j]+1;
                }else{
                    arr[j] = 0;
                }
            }
            int ans = largestRectangleArea(arr);
            if(ans>max){
                max = ans;
            }
        }
        return max;
    }
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
