class Solution {
    public int maximumProfit(int idx, int buy, int arr[],int dp[][]) {
        if(idx==arr.length)return 0;
        
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if (buy == 0) {
            dp[idx][buy]=  Math.max(-arr[idx] + maximumProfit(idx + 1, 1, arr,dp), 0 + maximumProfit(idx + 1, 0, arr,dp));
        } else {
            dp[idx][buy]=  Math.max(arr[idx] + maximumProfit(idx + 1, 0, arr,dp), 0 + maximumProfit(idx + 1, 1, arr,dp));

        }
        return dp[idx][buy];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
      return maximumProfit(0,0,prices,dp);
    }
}