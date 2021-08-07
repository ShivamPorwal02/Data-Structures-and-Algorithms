package LoveBabbar.DynamicProgramming;

import java.util.HashMap;

public class LargestAreaRectangularSubMatrixwithEqual1s0s {
    public void Submatrix(int r,int c,int[][] mat){

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    mat[i][j] = -1;
                }
            }
        }

        int maxarea = 0;
        int leftBound = 0;
        int rightBound = 0;
        int upBound = 0;
        int lowBound =0;

        int[] temp = new int[r];

        for(int left = 0; left<c;left++){
            for(int i=0;i<r;i++) temp[i] = 0;

            for(int right = left;right<c;right++){
                for(int i=0;i<r;i++){
                    temp[i]+=mat[i][right];
                }
                int res = largestSubarraywith0sum(temp);
                if(res*(right-left)>maxarea){
                    maxarea = res*(right-left);
                }
            }
        }
        // agr bole left ,right , up ,down dena hai to niche wale fn m start aur end krdo
        System.out.println(maxarea);
    }

    // agr ye smjh ni aae to dekhlena same qn hai issi m aur coding chhd dena fir

    int largestSubarraywith0sum(int[] arr){
        int sum = 0;
        int maxL = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                if(i-hm.get(sum)>maxL) {
                    maxL = i-hm.get(sum);
                    int start = hm.get(sum);
                    int end = i;
                }
            }
            else if(sum==0) {
                maxL = Math.max(maxL,i+1);
                int start = 0;
                int end = i;
            }
            else hm.put(sum,i);
        }
        return maxL;
    }
}
