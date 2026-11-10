// class Solution {
//   public int MAX(int idx,int buy,int arr[],int dp[][]){
//     if(idx>=arr.length) return 0;

//   if(dp[idx][buy]!=-1) return dp[idx][buy];
//     if(buy==0){
//         return dp[idx][buy] =  Math.max(-arr[idx]+MAX(idx+1,1,arr,dp),0+MAX(idx+1,0,arr,dp));
//     }else{
//         return dp[idx][buy] = Math.max(arr[idx]+MAX(idx+2,0,arr,dp),0+MAX(idx+1,1,arr,dp));
//     }
//   }

//     public int maxProfit(int[] prices) {
//     int dp[][] = new int[prices.length][2];
//     for(int i=0;i<prices.length;i++){
//         Arrays.fill(dp[i],-1);
//     }
//      return MAX(0,0,prices,dp);
//     }
// }

//tabulation

class Solution {
  public int MAX(int idx,int buy,int arr[],int dp[][]){

    dp[arr.length][0] =0;
    dp[arr.length][1] =0;


for(int i=arr.length-1;i>=0;i--)

    {
        for (int j = 0; j <= 1; j++) {
            if (j == 0) {
                 dp[i][j] = Math.max(-arr[i] + dp[i+1][1], 0 + dp[i+1][0]);
            } else {
                 dp[i][j] = Math.max(arr[i] + dp[i+2][0], 0 + dp[i+1][1]);
            }
        }
    }
    return dp[idx][buy];
  }

    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+2][2];
        return MAX(0, 0, prices, dp);
    }
}