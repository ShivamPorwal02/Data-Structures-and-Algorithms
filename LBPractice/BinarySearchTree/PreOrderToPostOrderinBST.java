package LoveBabbar.BinarySearchTree;

public class PreOrderToPostOrderinBST {
        // ye O(N) aur O(1) space m kia hai
        // normally to pre se in nikal k aur fir tree bnak post order
        public static void PreToPost(int[] pre) {
            preTopost(0,pre.length-1,pre);
        }
        public static void preTopost(int start,int end,int[] pre){
            if(start>end) return;

            int mid = start+1;

            while(mid<=end && pre[mid]<=pre[start]){
                mid++;
            }
            mid--;


            // LeftRightRoot hota hai post m hai eese calls islia kia hai
            preTopost(start+1,mid,pre);
            preTopost(mid+1,end,pre);
            System.out.print(pre[start]+" ");
        }
    }
