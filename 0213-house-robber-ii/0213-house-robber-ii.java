

class Solution {
    public static int maximum(int idx, int nums[], int dp[]) {
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
             if(i>=2){
              pick =  pick + dp[i - 2];
             } 
            int notPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[idx];
    }

    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n = nums.length;
        int dp[] = new int[n];
        int temp[] = new int[n];
        int temp2[] = new int[n];
        for(int i=0;i<temp.length;i++){
           if(i!=0){
            temp[i] = nums[i];
           }
           if(i!=nums.length-1){
            temp2[i] = nums[i];
           }
        }
        return Math.max(maximum(temp.length-1,temp,dp),maximum(temp2.length-1,temp2,dp));
    }
}