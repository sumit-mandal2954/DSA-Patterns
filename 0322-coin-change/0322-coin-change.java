class Solution {
    public int minimumCoin(int idx,int arr[],int amount,int dp[][]){
      if(idx==0){
        if(amount%arr[0]==0){
            return amount/arr[0];
        }else{
          return (int) 1e9;
        }
      }
      if(dp[idx][amount]!=-1) return dp[idx][amount];

        int notTake =  0+minimumCoin(idx-1,arr,amount,dp);
        int take = Integer.MAX_VALUE;
        if(arr[idx]<=amount){
            take =  1+minimumCoin(idx,arr,amount-arr[idx],dp);
        }
        return dp[idx][amount]=Math.min(notTake,take);
    }
    public int coinChange(int[] coins, int amount) {
        int n  = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = minimumCoin(n-1,coins,amount,dp);
        if(ans>= (int)1e9) return -1;
        else return ans;
    }
}