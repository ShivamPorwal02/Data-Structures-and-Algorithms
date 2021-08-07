package LoveBabbar.SortingAndSearching;

public class ProductExceptSelf {
    public int[] productexceptSelf(int[] nums) {
        // method 1 ( with division + O(N) time + O(1) )
        int n = nums.length;
        int[] pam = new int[n];
        int mul = 1;
        int cnt = 0;
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                flag = true;
                cnt++;
                continue;
            }
            mul*=nums[i];
        }
        if(cnt>1){
            return pam;
        }
        for(int i=0;i<n;i++){
            if(flag && nums[i]!=0){
                pam[i]  = 0;
            }else if(flag && nums[i]==0){
                pam[i] = mul;
            }else{
                pam[i] = mul/nums[i];
            }
        }
        return pam;
    }
    public int[] method2(int[] nums){
        // method 2 ( without division + O(N) time + O(N) space )
        int[] ans = new int[nums.length];
        int[] lma = new int[nums.length];
        int[] rma = new int[nums.length];
        lma[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            lma[i] = lma[i-1]*nums[i];
        }
        rma[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            rma[i] = rma[i+1]*nums[i];
        }

        for(int i=0;i<nums.length;i++){
            if(i==0){
                ans[0] = rma[1];
            }else if(i==nums.length-1){
                ans[nums.length-1] = lma[nums.length-2];
            }else{
                ans[i] = lma[i-1]*rma[i+1];
            }
        }
        return ans;

    }
    public int[] method3(int[] nums){
        // method 2 ( without division + O(N) time + O(1) space )
        int[] ans = new int[nums.length];
        int prod = 1;
        ans[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i] = ans[i-1]*nums[i];
        }

        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                ans[i] = ans[nums.length-2];
            }else if(i==0){
                ans[i] = prod;
            }else{
                ans[i] = ans[i-1]*prod;
            }
            prod*=nums[i];
        }

        return ans;
    }
}
