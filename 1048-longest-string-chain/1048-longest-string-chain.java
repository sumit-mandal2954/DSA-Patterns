class Solution {

    public boolean compares(String s1, String s2) {
        if (s1.length() != 1 + s2.length())
            return false;
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == s2.length())
            return true;
        else
            return false;
    }

    public int longestStrChain(String[] arr) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 1);
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (compares(arr[i], arr[prev]) && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}