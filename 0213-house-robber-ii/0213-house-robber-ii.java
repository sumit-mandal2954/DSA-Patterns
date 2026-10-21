// class Solution {
//     public static int maximum(int idx, int nums[]) {
//         if (idx == 0)
//             return nums[idx];
//         if (idx < 0)
//             return 0;
//         int pick = nums[idx] + maximum(idx - 2, nums);
//         int notPick = 0 + maximum(idx - 1, nums);
//         return Math.max(pick,notPick);
//     }

//     public int rob(int[] nums) {
//         int n = nums.length;
//         return maximum(n - 1, nums);
//     }
// }

// class Solution {
//     public static int maximum(int idx, int nums[],int dp[]) {
//         if (idx == 0)
//             return nums[idx];
//         if (idx < 0)
//             return 0;
//          if(dp[idx]!=-1) return dp[idx];   
//         int pick = nums[idx] + maximum(idx - 2, nums,dp);
//         int notPick = 0 + maximum(idx - 1, nums,dp);
//         return dp[idx] = Math.max(pick,notPick);
//     }

//     public int rob(int[] nums) {
//         int n = nums.length;
//         int dp[] = new int[n];
//         Arrays.fill(dp,-1);
//         return maximum(n - 1, nums,dp);
//     }
// }

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