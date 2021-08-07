package LoveBabbar;

public class TrappingRainWater {

    // with extra space
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int[] preMax = new int[height.length];
        int[] sufMax = new int[height.length];

        int premax = height[height.length-1];
        int sufmax = height[0];

        for(int i=0;i<height.length;i++){
            if(height[i]>=sufmax){
                sufmax = height[i];
            }
            sufMax[i] = sufmax;
        }
        for(int i=height.length-1;i>=0;i--){
            if(height[i]>=premax){
                premax = height[i];
            }
            preMax[i] = premax;
        }
        int ans = 0;
        for(int i=0;i<height.length;i++){
            if(Math.min(preMax[i],sufMax[i])-height[i]>0){
                ans+=Math.min(preMax[i],sufMax[i])-height[i];
            }
        }
        return ans;
    }

    // without extra space //


//    if(arr.length==0){
//        return 0;
//    }
//    int leftindex = 0;
//    int rightindex = arr.length-1;
//    int leftMax = 0;
//    int rightMax = 0;
//    int ans = 0;
//
//        while(leftindex<=rightindex){
//        if(arr[leftindex]<=arr[rightindex]){
//            if(arr[leftindex]>leftMax){
//                leftMax = arr[leftindex];
//            }else{
//                ans+=(leftMax-arr[leftindex]);
//            }
//            leftindex++;
//        }else{
//            if(arr[rightindex]>rightMax){
//                rightMax = arr[rightindex];
//            }else{
//                ans+=(rightMax-arr[rightindex]);
//            }
//            rightindex--;
//        }
//    }
//        return ans;
//
//}
}
