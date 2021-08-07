package MayChallenge;

public class CountPrimes {

    // https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3738/
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i=2;i<n;i++){
            isPrime[i] = true;
        }
        for(int i=2;i*i<n;i++){
            if(isPrime[i] ==false){
                continue;
            }
            for(int j=i*i;j<n;j+=i){
                isPrime[j] = false;
            }
        }

        int cnt = 0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
