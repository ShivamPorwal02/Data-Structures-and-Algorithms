package Revision;

import java.util.ArrayList;

public class StockBuySell {
    ArrayList<ArrayList<Integer>> stockBuySell(int arr[], int n) {
        // code here
        int min = 0;
        int max = 0;

        int i = 0;
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        while (i < arr.length - 1) {
            while (i < arr.length - 1 && arr[i + 1] <= arr[i]) {
                i++;
            }
            min = i;
            i++;

            while (i < arr.length && arr[i] >= arr[i - 1]) {
                i++;
            }
            max = i - 1;
            // i--;
            if (min < max) {
                ArrayList<Integer> lst1 = new ArrayList<>();
                lst1.add(min);
                lst1.add(max);
                lst.add(lst1);
            }

        }
        // for(ArrayList<Integer> ls : lst) System.out.print("("+ ls.get(0)+" "+ls.get(1)+") ");

        return lst;
    }
}
