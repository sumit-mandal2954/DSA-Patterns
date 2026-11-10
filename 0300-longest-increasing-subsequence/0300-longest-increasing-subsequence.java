class Solution {
    public int LIS(int idx, int Pidx, int arr[], int dp[][]) {

        if (idx == arr.length)
            return 0;
      
        if (dp[idx][Pidx+1] != -1)
            return dp[idx][Pidx+1];

        int notTake = LIS(idx + 1, Pidx, arr, dp);
        int take = 0;
        if (Pidx == -1 || arr[idx] > arr[Pidx]) {
            take = 1 + LIS(idx + 1, idx, arr, dp);
        }
        return dp[idx][Pidx+1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return LIS(0, -1, nums, dp);
    }
}