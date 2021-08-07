package Revision;

public class Stock_AtmostTwoTransactions {
    public int maxProfit(int[] prices) {

        int maxProToday = 0;
        int leastsf = prices[0];
        int[] dp1 = new int[prices.length];

        for(int i=1;i<prices.length;i++){
            if(prices[i]<leastsf) leastsf = prices[i];

            maxProToday = prices[i] - leastsf;
            if(maxProToday>dp1[i-1]) dp1[i] = maxProToday;
            else dp1[i] = dp1[i-1];

        }

        int maxProBToday = 0;
        int maxsf = prices[prices.length-1];
        int[] dp2 = new int[prices.length];

        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]>maxsf) maxsf = prices[i];

            maxProBToday = maxsf - prices[i];
            if(maxProBToday>dp2[i+1]) dp2[i] = maxProBToday;
            else dp2[i] = dp2[i+1];
        }

        int omax = 0;
        for(int i=0;i<prices.length;i++){
            omax = Math.max(omax,dp1[i]+dp2[i]);
        }
        return omax;
    }
}
