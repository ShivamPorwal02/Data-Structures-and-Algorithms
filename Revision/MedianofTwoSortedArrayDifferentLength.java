package Revision;

public class MedianofTwoSortedArrayDifferentLength {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int lo = 0;
        int high = nums1.length;
        // hm chote waale array prr binary search lgare hai


        while(lo<=high){
            int cut1 = (lo+high)/2;
            int cut2 = ((nums1.length+nums2.length)/2)-cut1;

            int l1 = cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
            int l2 = cut2==0?Integer.MIN_VALUE:nums2[cut2-1];
            int r1 = cut1==nums1.length?Integer.MAX_VALUE:nums1[cut1];
            int r2 = cut2==nums2.length?Integer.MAX_VALUE:nums2[cut2];

            if(l1>r2){
                high = cut1-1;

            }else if(l2>r1){
                lo = cut1+1;
            }else{
                return (nums1.length+nums2.length)%2==0                                                                      ? (Math.max(l1,l2)+Math.min(r1,r2))/2.0
                        : Math.min(r1,r2);

            }
        }
        return 0;
    }
}
