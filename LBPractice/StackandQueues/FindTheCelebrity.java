package LoveBabbar.StackandQueues;

import java.util.Stack;

public class FindTheCelebrity {
    int celebrity(int M[][], int n)
    {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }

        while(st.size()>=2){
            int a = st.pop();
            int b = st.pop();

            if(M[a][b] == 1){
                st.push(b);
            }else{
                st.push(a);
            }
        }

        int pot = st.pop();

        for(int i=0;i<n;i++){
            if(i!=pot){
                if(M[i][pot] == 0 || M[pot][i] == 1){
                    return -1;
                }
            }
        }
        return pot;
    }
}
