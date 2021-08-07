package LoveBabbar.DynamicProgramming;

public class _2D_KadanesAlgorithm {
    class kadane2d{
        int sum;
        int up;
        int low;

        kadane2d(int sum,int low,int up){
            this.sum = sum;
            this.low = low;
            this.up = up;
        }
    }
    public int _2D_kadane(int r,int c,int[][] mat){
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
                kadane2d res = kadane(temp);
                if(res.sum>maxSum){
                    maxSum = res.sum;
                    leftBound = left;
                    rightBound = right;
                    upBound = res.low;
                    lowBound = res.up;
                }
            }
        }
        return maxSum;
    }
    kadane2d kadane(int[] temp) {
        int currSum = temp[0];
        int maxSum = temp[0];
        int start = 0;
        int end = 0;
        int returnstart = 0;
        int returnend = 0;
        for (int i = 1; i < temp.length; i++) {
            if (currSum > 0) {
                currSum += temp[i];
                end = i;
            } else {
                currSum = temp[i];
                start = end = i;
            }
            if (currSum > maxSum) {
                maxSum = currSum;
                returnstart = start;
                returnend = end;
            }
        }
        return new kadane2d(maxSum, returnstart, returnend);
    }

}
