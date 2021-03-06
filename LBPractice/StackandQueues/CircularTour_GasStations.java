package LoveBabbar.StackandQueues;

public class CircularTour_GasStations {
    int tour(int gas[], int cost[])
    {
        // Your code here

//        https://www.youtube.com/watch?v=zcnVaVJkLhY

        //     The reason why I think this works:
// 1, if sum of gas is more than sum of cost, then there must be a solution. And the question guaranteed that the solution is unique(The first one I found is the right one).
// 2, The tank should never be negative, so restart whenever there is a negative number.

        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank =0;
        for(int i=0;i<gas.length;i++){
            sumGas+=gas[i];
            sumCost+=cost[i];
            tank+=gas[i]-cost[i];
            if(tank<0){
                start = i+1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }
}
