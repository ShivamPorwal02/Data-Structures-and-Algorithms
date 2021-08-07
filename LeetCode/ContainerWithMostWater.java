package LeetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i= 0;
        int j = height.length-1;
        int water = 0;
        while(i<j){
            int w = j-i;
            if(height[i]<height[j]){
                water = Math.max(water,w*height[i]);
                i++;
            }else{
                water = Math.max(water,w*height[j]);
                j--;
            }
        }
        return water;
    }
}
