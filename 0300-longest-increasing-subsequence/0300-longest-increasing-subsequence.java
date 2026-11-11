// class Solution {
//     public int LIS(int idx, int Pidx, int arr[], int dp[][]) {

//         if (idx == arr.length)
//             return 0;

//         if (dp[idx][Pidx+1] != -1)
//             return dp[idx][Pidx+1];

//         int notTake = LIS(idx + 1, Pidx, arr, dp);
//         int take = 0;
//         if (Pidx == -1 || arr[idx] > arr[Pidx]) {
//             take = 1 + LIS(idx + 1, idx, arr, dp);
//         }
//         return dp[idx][Pidx+1] = Math.max(take, notTake);
//     }

//     public int lengthOfLIS(int[] nums) {
//         int dp[][] = new int[nums.length][nums.length+1];
//         for (int i = 0; i < dp.length; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return LIS(0, -1, nums, dp);
//     }
// }

//tabulation

// class Solution {
//     public int LIS(int idx, int Pidx, int arr[], int dp[][]) {

//         for (int i = 0; i <= arr.length; i++) {
//             dp[arr.length][i] = 0;
//         }

//         for (int i = arr.length - 1; i >= 0; i--) {
//             for (int pre = i - 1; pre >= -1; pre--) {
//                 int notTake = dp[i + 1][pre + 1];
//                 int take = 0;
//                 if (pre == -1 || arr[i] > arr[pre]) {
//                     take = 1 + dp[i + 1][i + 1];
//                 }
//                 dp[i][pre + 1] = Math.max(take, notTake);
//             }
//         }
//         return dp[idx][Pidx + 1];
//     }

//     public int lengthOfLIS(int[] nums) {
//         int dp[][] = new int[nums.length + 1][nums.length + 1];
//         return LIS(0, -1, nums, dp);
//     }
// }

// tabulation another method

class Solution {
    public int lengthOfLIS(int[] arr) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int pre = 0; pre < i; pre++) {
                if (arr[pre] < arr[i] && 1 + dp[pre] > dp[i]) {
                    dp[i] = 1 + dp[pre];
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}