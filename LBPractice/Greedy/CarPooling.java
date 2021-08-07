package LoveBabbar.Greedy;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {

        int MAX_LOCATIONS = 1001; // qn m dia hai constraint m

        int[] locations = new int[1001];

        for(int[] t : trips){
            int num_passengers = t[0];
            int start = t[1];
            int end = t[2];

            locations[start]+=num_passengers;
            locations[end]-=num_passengers;
        }
        int cnt = 0;
        for(int i = 0;i<1001;i++){
            cnt+=locations[i];
            if(cnt>capacity) return false;
        }
        return true;
    }
}
