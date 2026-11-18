// class Solution {
//     public boolean isPalindrome(int i, int j, String s) {
//         while (i < j) {
//             if (s.charAt(i) != s.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }

//     public int PP(int i, String s, int dp[]) {
//         if (i == s.length())
//             return 0;

//         if (dp[i] != -1)
//             return dp[i];
//         int min = Integer.MAX_VALUE;
//         for (int k = i; k < s.length(); k++) {
//             if (isPalindrome(i, k, s)) {
//                 int cuts = 1 + PP(k + 1, s, dp);
//                 min = Math.min(min, cuts);
//             }
//         }
//         return dp[i] = min;
//     }

//     public int minCut(String s) {
//         int dp[] = new int[s.length()];
//         Arrays.fill(dp, -1);
//         return PP(0, s, dp) - 1;
//     }
// }

// tbaulation

class Solution {
    public boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int PP(int i, String s, int dp[]) {
        dp[s.length()] = 0;

        for (int idx = s.length() - 1; idx >= 0; idx--) {
            int min = Integer.MAX_VALUE;
            for (int k = idx; k < s.length(); k++) {
                if (isPalindrome(idx, k, s)) {
                    int cuts = 1 + dp[k+1];
                    min = Math.min(min, cuts);
                }
            }
            dp[idx] = min;
        }
        return dp[i];
    }

    public int minCut(String s) {
        int dp[] = new int[s.length()+1];
        return PP(0, s, dp) - 1;
    }
}