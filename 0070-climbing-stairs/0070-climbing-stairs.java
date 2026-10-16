class Solution {

    public int DP(int n,int dp[]){
        if(n==0||n==1) return 1;
        if(dp[n]!=-1) return dp[n];
         int left = DP(n-1,dp);
         int right = DP(n-2,dp);
        dp[n] = left+right;
        return left+right;

    }
    public int climbStairs(int n) {
     int dp[] = new int[n+1];
      Arrays.fill(dp,-1);
      return DP(n,dp);
    }
}