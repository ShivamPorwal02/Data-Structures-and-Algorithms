package LoveBabbar.LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class Trucks
    {
        public static void main(String[] args)
        {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int m = scn.nextInt();
            int[] stones = new int[n];
            for (int i=0;i<stones.length;i++){
                stones[i] = scn.nextInt();
            }
            int[] boxes = new int[m];
            for (int i=0;i<boxes.length;i++){
                boxes[i] = scn.nextInt();
            }
            int ans = solve(stones,boxes);
            System.out.println(ans);
        }
        public static int solve(int[] stones,int[] boxes){
            if(stones.length==0 || boxes.length==0){
                return 0;
            }
            Arrays.sort(stones);
            Arrays.sort(boxes);
            if(stones[0]*2>boxes[boxes.length-1]) return 0;

            int occupied = 0;
            int cnt = 0;
            int j = 0;
            for(int i=0;i<stones.length;i++){
                if(occupied>=boxes.length){
                    return cnt;
                }else{
                    for(;j<boxes.length;j++){
                        if(boxes[j]>=2*stones[i]){
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }
    }
