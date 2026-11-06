// class Solution {
//     public int BS(int idx, int buy, int cap, int arr[], int dp[][][]) {
//         if (cap == 0)
//             return 0;
//         if (idx == arr.length)
//             return 0;

//         if (dp[idx][buy][cap] != -1)
//             return dp[idx][buy][cap];
//         if (buy == 0) {
//             return dp[idx][buy][cap] = Math.max(-arr[idx] + BS(idx + 1, 1, cap, arr, dp),
//                     0 + BS(idx + 1, 0, cap, arr, dp));
//         } else {
//             return dp[idx][buy][cap] = Math.max(arr[idx] + BS(idx + 1, 0, cap - 1, arr, dp),
//                     0 + BS(idx + 1, 1, cap, arr, dp));
//         }
//     }

//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int dp[][][] = new int[n][2][3];
//         for (int i = 0; i < dp.length; i++) {
//             for (int j = 0; j < dp[i].length; j++) {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }
//         return BS(0, 0, 2, prices, dp);
//     }
// }

//tabulation

class Solution {
    public int BS(int idx, int buy, int k, int arr[], int dp[][][]) {

        for (int i = 0; i < arr.length; i++) {
            for (int b = 0; b <= 1; b++) {
                dp[i][b][0] = 0;
            }
        }
        for (int c = 0; c <= 2; c++) {
            for (int b = 0; b <= 1; b++) {
                dp[arr.length][b][k] = 0;
            }
        }

        for (int i = arr.length-1; i >=0; i--) {
            for (int b = 0; b <= 1; b++) {
                for (int c = 1; c <= k; c++) {
                    if (b == 0) {
                         dp[i][b][c] = Math.max(-arr[i] + dp[i+1][1][c],
                                0 + dp[i+1][0][c]);
                    } else {
                         dp[i][b][c] = Math.max(arr[i] + dp[i+1][0][c-1],
                                0 + dp[i+1][1][c]);
                    }
                }
            }
        }
        return dp[idx][buy][k];
    }

    public int maxProfit(int k,int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][k+1];
        return BS(0, 0, k, prices, dp);
    }
}