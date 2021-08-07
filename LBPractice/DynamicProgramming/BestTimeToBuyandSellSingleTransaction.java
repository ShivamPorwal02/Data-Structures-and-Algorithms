package LoveBabbar.DynamicProgramming;

public class BestTimeToBuyandSellSingleTransaction {
    public int maxProfit(int[] a) {
        int[] dp = new int[a.length];
        int min = a[0];
        int max = 0;
        for(int i = 1;i<a.length;i++){
            if(a[i]<min){
                min = a[i];
            }
            if(a[i]-min>max){
                max = a[i] - min;
            }
        }
        return max;
    }
}
