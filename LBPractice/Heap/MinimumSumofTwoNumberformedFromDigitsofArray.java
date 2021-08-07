package LoveBabbar.Heap;

import java.util.PriorityQueue;

public class MinimumSumofTwoNumberformedFromDigitsofArray {
    public static long minSum(int arr[], int n)
    {
        // Your code goes here
        if(n==0) return 0;
        if(n==1) return arr[0];
        // code here
        String n1 = "";
        String n2 = "";

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        int mul = (int)Math.pow(10,0);
        while(pq.size()>1){
            int a = pq.remove();
            int b = pq.remove();

            if(a!=0) n1+=a;
            if(b!=0) n2+=b;
        }
        if(n1=="") n1 = "0";
        if(n2 == "") n2 = "0";
        if(pq.size()>0){
            if(Long.parseLong(n1)>Long.parseLong(n2)){
                n2 += pq.remove();
            }else{
                n1+= pq.remove();
            }
        }
        // System.out.println(n1);
        // System.out.println(n2);
        long ans = Long.parseLong(n1)+Long.parseLong(n2);
        return ans;
    }
}
