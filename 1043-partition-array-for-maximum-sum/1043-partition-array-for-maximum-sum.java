class Solution {
    public int MaxSum(int i, int k, int[] arr,int dp[]) {
        if (i == arr.length)
            return 0;



      if(dp[i]!=-1)return dp[i];
        int len = 0;
        int max = Integer.MIN_VALUE;
        int MaxAns = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(arr.length, i + k); j++) {
            len++;
            max = Math.max(max, arr[j]);
            int sum = (len * max) + MaxSum(j+1,k,arr,dp);
            MaxAns = Math.max(sum, MaxAns);
        }
        return dp[i]= MaxAns;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return MaxSum(0, k, arr,dp);
    }
}