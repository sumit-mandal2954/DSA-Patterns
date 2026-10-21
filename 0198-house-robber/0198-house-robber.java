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


class Solution {
    public static int maximum(int idx, int nums[],int dp[]) {
        if (idx == 0)
            return nums[idx];
        if (idx < 0)
            return 0;
         if(dp[idx]!=-1) return dp[idx];   
        int pick = nums[idx] + maximum(idx - 2, nums,dp);
        int notPick = 0 + maximum(idx - 1, nums,dp);
        return dp[idx] = Math.max(pick,notPick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return maximum(n - 1, nums,dp);
    }
}