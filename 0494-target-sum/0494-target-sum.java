class Solution {
    public int countSubset(int idx, int arr[], int target, int dp[][]) {
        if (arr[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (arr[i] <= t) {
                    take = dp[i - 1][t - arr[i]];
                }
                dp[i][t] = notTake + take;
            }
        }
        return dp[idx][target];
    }

    public int totalSum(int arr[]) {
        int sum = 0;
        for (var i : arr)
            sum += i;
        return sum;
    }

    public int findTargetSumWays(int[] nums, int target) {
        // if(nums.length==1&&arr[0]<) return 0;
        int n = nums.length;
        int totalSum = totalSum(nums);
        if (totalSum+target<0||(totalSum + target) % 2 != 0)
            return 0;
        int diff = (totalSum + target) / 2;
        int dp[][] = new int[n][diff + 1];
        return countSubset(n - 1, nums, diff, dp);
    }
}