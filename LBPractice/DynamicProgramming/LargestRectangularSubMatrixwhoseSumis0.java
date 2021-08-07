package LoveBabbar.DynamicProgramming;

import java.util.HashMap;

public class LargestRectangularSubMatrixwhoseSumis0 {
    public void Submatrix(int r,int c,int[][] mat){
    int max = Integer.MIN_VALUE;
    boolean flag = false;
        for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(mat[i][j]>0){
                flag = true;
                break;
            }
            if(mat[i][j]>max) max = mat[i][j];
        }
    }

        if(flag==false) System.out.println("not possible");//return max;

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
        int start  = 0 ;
        int end = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                if(i-hm.get(sum)>maxL) {
                    maxL = i-hm.get(sum);
                    start = hm.get(sum);
                    end = i;
                }
            }
            else if(sum==0) {
                maxL = Math.max(maxL,i+1);
                start = 0;
                end = i;
            }
            else hm.put(sum,i);
        }
        return maxL;
    }
}
