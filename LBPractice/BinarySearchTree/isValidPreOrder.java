package LoveBabbar.BinarySearchTree;

import java.util.Stack;

public class isValidPreOrder {
    static int canRepresentBST(int arr[], int N) {
        // code here
        Stack<Integer> st = new Stack<>();

        int root = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){

            while(st.size()>0 && arr[i] > st.peek()){
                root = st.pop();
            }
            if(arr[i]<root) return 0;

            st.push(arr[i]);
        }
        return 1;
    }
}
