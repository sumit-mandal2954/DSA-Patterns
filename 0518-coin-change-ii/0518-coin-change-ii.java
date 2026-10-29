// class Solution {
//     public int CountChange(int idx,int arr[],int amount,int dp[][]){
//      if(amount==0)return 1;
//      if(idx==0){
//         if(amount%arr[idx]==0)return 1;
//         else return 0;
//      }

//      if(dp[idx][amount]!=-1) return dp[idx][amount]; 

//      int notTake = CountChange(idx-1,arr,amount,dp);
//      int take = 0;
//      if(arr[idx]<=amount){
//         take = CountChange(idx,arr,amount-arr[idx],dp);
//      }
//      return dp[idx][amount] =  take+notTake;
//     }
//     public int change(int amount, int[] coins) {
//       int n = coins.length;
//       int dp[][] = new int[n][amount+1];
//       for(int i=0;i<coins.length;i++){
//         Arrays.fill(dp[i],-1);
//       }
//       return CountChange(n-1,coins,amount,dp);
//     }
// }

//tabulation

class Solution {
    public int CountChange(int idx, int arr[], int amount, int dp[][]) {

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int t = 0; t <= amount; t++) {
            if (t % arr[0] == 0) {
                dp[0][t] = 1;
            } else {
                dp[0][t] = 0;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int t = 0; t <= amount; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (arr[i] <= t) {
                    take = dp[i][t-arr[i]];
                }
                dp[i][t] = notTake+take;
            }
        }

        return dp[idx][amount];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        return CountChange(n - 1, coins, amount, dp);
    }
}