package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class BoxStacking {
    public static class Box implements Comparable<Box>{
        int h;
        int w;
        int l;
        int area;
        Box(int h,int w,int l){
            this.h = h;
            this.w = w;
            this.l = l;
        }
        /*To sort the box array on the basis
        of area in decreasing order of area */
        public int compareTo(Box o){
            return o.area-this.area;
        }
    }
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        // Code here
        Box[] box = new Box[3*n];

        for(int i=0;i<n;i++){
            box[3*i] = new Box(height[i],Math.max(width[i],length[i]),Math.min(width[i],length[i]));
            box[3*i+1] = new Box(width[i],Math.max(height[i],length[i]),Math.min(height[i],length[i]));
            box[3*i+2] = new Box(length[i],Math.max(width[i],height[i]),Math.min(width[i],height[i]));
        }
        for(int i=0;i<box.length;i++){
            box[i].area = box[i].w*box[i].l;
        }

        Arrays.sort(box);

        int omax = 0;
        int[] dp = new int[box.length];
        for(int i=0;i<box.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(box[j].w>box[i].w && box[j].l > box[i].l){
                    if(dp[j]>max) max = dp[j];
                }
            }
            dp[i] = box[i].h + max;
            if(dp[i] > omax) omax = dp[i];
        }
        return omax;
    }
}
