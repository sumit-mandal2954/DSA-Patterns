// class Solution {
//     public int minimumCoin(int idx,int arr[],int amount,int dp[][]){
//       if(idx==0){
//         if(amount%arr[0]==0){
//             return amount/arr[0];
//         }else{
//           return (int) 1e9;
//         }
//       }
//       if(dp[idx][amount]!=-1) return dp[idx][amount];

//         int notTake =  0+minimumCoin(idx-1,arr,amount,dp);
//         int take = Integer.MAX_VALUE;
//         if(arr[idx]<=amount){
//             take =  1+minimumCoin(idx,arr,amount-arr[idx],dp);
//         }
//         return dp[idx][amount]=Math.min(notTake,take);
//     }
//     public int coinChange(int[] coins, int amount) {
//         int n  = coins.length;
//         int dp[][] = new int[n][amount+1];
//         for(int i=0;i<dp.length;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         int ans = minimumCoin(n-1,coins,amount,dp);
//         if(ans>= (int)1e9) return -1;
//         else return ans;
//     }
// }

/// Tabulation

class Solution {
    public int minimumCoin(int idx, int arr[], int amount, int dp[][]) {

        for (int t = 0; t <= amount; t++) {
            if (t % arr[0]==0)
                dp[0][t] = t / arr[0];
            else
                dp[0][t] = (int) 1e9;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = 0 + dp[i - 1][target];
                int take = Integer.MAX_VALUE;
                if (arr[i] <= target) {
                    take = 1 + dp[i][target-arr[i]];
                }
              dp[i][target] = Math.min(notTake,take);
            }
        }
        return dp[idx][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        int ans = minimumCoin(n - 1, coins, amount, dp);
        if (ans >= (int) 1e9)
            return -1;
        else
            return ans;
    }
}