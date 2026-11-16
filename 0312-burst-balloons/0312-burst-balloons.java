//TC :- N^3

// class Solution {
//     public int MaxBurst(int i, int j, int arr[],int dp[][]) {
//         if (i > j)
//             return 0;

//         int max = Integer.MIN_VALUE;
//         if(dp[i][j]!=-1) return dp[i][j];
//         for (int k = i; k <= j; k++) {
//             int cost = arr[i - 1] * arr[k] * arr[j + 1] + MaxBurst(i, k - 1, arr,dp) + MaxBurst(k + 1, j, arr,dp);
//             max = Math.max(max, cost);
//         }
//         return dp[i][j]= max;
//     }

//     public int maxCoins(int[] nums) {
//         int new_arr[] = new int[nums.length+2];
//         new_arr[0] =1;
//         for(int i=0;i<nums.length;i++){
//             new_arr[i+1] = nums[i];
//         }
//         new_arr[new_arr.length-1] = 1;
//         int dp[][] = new int[nums.length+1][nums.length+1];
//         for(int i=0;i<dp.length;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return MaxBurst(1,new_arr.length-2,new_arr,dp);
//     }
// }

class Solution {
    public int MaxBurst(int i, int j, int arr[], int dp[][]) {
        for (int idx1 = arr.length - 2; idx1 >= 1; idx1--) {
            for (int idx2 = 1; idx2 <= j; idx2++) {
                if(idx1>idx2) continue;
                int max = Integer.MIN_VALUE;
                for (int k = idx1; k <= idx2; k++) {
                    int cost = arr[idx1 - 1] * arr[k] * arr[idx2 + 1] + dp[idx1][k - 1]
                            + dp[k + 1][idx2];
                    max = Math.max(max, cost);
                }
                dp[idx1][idx2] = max;
            }
        }
        return dp[i][j];
    }

    public int maxCoins(int[] nums) {
        int new_arr[] = new int[nums.length + 2];
        new_arr[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            new_arr[i + 1] = nums[i];
        }
        new_arr[new_arr.length - 1] = 1;
        int dp[][] = new int[nums.length + 2][nums.length + 2];
        return MaxBurst(1, new_arr.length - 2, new_arr, dp);
    }
}