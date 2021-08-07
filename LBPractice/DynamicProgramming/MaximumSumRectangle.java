package LoveBabbar.DynamicProgramming;

public class MaximumSumRectangle {
    int maximumSumRectangle(int r, int c, int mat[][]) {

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

        if(flag==false) return max;

        int maxSum = 0;
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
                int res = kadane(temp);
                if(res>maxSum){
                    System.out.println(res);
                    maxSum = res;
                }
            }
        }
        return maxSum;
    }
    int kadane(int[] temp){
        int currSum = temp[0];
        int maxSum = temp[0];

        for(int i=1;i<temp.length;i++){
            if(currSum>0){
                currSum+=temp[i];
            }else{
                currSum = temp[i];
            }
            if(currSum>maxSum) maxSum = currSum;
        }
        return maxSum;
    }
}
