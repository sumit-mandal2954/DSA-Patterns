class Solution {
    public int CountChange(int idx,int arr[],int amount,int dp[][]){
     if(amount==0)return 1;
     if(idx==0){
        if(amount%arr[idx]==0)return 1;
        else return 0;
     }

     if(dp[idx][amount]!=-1) return dp[idx][amount]; 

     int notTake = CountChange(idx-1,arr,amount,dp);
     int take = 0;
     if(arr[idx]<=amount){
        take = CountChange(idx,arr,amount-arr[idx],dp);
     }
     return dp[idx][amount] =  take+notTake;
    }
    public int change(int amount, int[] coins) {
      int n = coins.length;
      int dp[][] = new int[n][amount+1];
      for(int i=0;i<coins.length;i++){
        Arrays.fill(dp[i],-1);
      }
      return CountChange(n-1,coins,amount,dp);
    }
}