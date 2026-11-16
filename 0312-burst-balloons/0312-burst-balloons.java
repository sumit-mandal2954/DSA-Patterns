class Solution {
    public int MaxBurst(int i, int j, int arr[],int dp[][]) {
        if (i > j)
            return 0;

        int max = Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for (int k = i; k <= j; k++) {
            int cost = arr[i - 1] * arr[k] * arr[j + 1] + MaxBurst(i, k - 1, arr,dp) + MaxBurst(k + 1, j, arr,dp);
            max = Math.max(max, cost);
        }
        return dp[i][j]= max;
    }

    public int maxCoins(int[] nums) {
        int new_arr[] = new int[nums.length+2];
        new_arr[0] =1;
        for(int i=0;i<nums.length;i++){
            new_arr[i+1] = nums[i];
        }
        new_arr[new_arr.length-1] = 1;
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return MaxBurst(1,new_arr.length-2,new_arr,dp);
    }
}