package LoveBabbar.DynamicProgramming;

public class BestTimetoBuyandSellInfiniteTransaction {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int bd = 0;
        int sd = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]) sd++;
            else{
                profit+=(prices[sd]-prices[bd]);
                sd=bd = i;
            }
        }
        profit+=(prices[sd]-prices[bd]);
        return profit;
    }
}
