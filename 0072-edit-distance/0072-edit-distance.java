// class Solution {
//     public int minimum(int idx1, int idx2, String s1, String s2,int dp[][]) {
//         if (idx1 < 0) {
//             return idx2 + 1;
//         }
//         if (idx2 < 0) {
//             return idx1 + 1;
//         }
//         if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

//         if (s1.charAt(idx1) == s2.charAt(idx2)) {
//             dp[idx1][idx2]=  0 + minimum(idx1 - 1, idx2 - 1, s1, s2,dp);
//         } else {
//             int insert = 1 + minimum(idx1, idx2 - 1, s1, s2,dp);
//             int delete = 1 + minimum(idx1 - 1, idx2, s1, s2,dp);
//             int replace = 1 + minimum(idx1 - 1, idx2 - 1, s1, s2,dp);
//             dp[idx1][idx2] =  Math.min(insert,Math.min(delete,replace));
//         }
//         return dp[idx1][idx2];
//     }

//     public int minDistance(String word1, String word2) {
//         int n1 = word1.length();
//         int n2 = word2.length();
//         int dp[][] = new int[n1][n2];
//         for(int i =0;i<dp.length;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return minimum(n1 - 1, n2 - 1, word1, word2,dp);
//     }
// }

//tabulation

class Solution {
    public int minimum(int idx1, int idx2, String s1, String s2, int dp[][]) {
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 0 + dp[i-1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[idx1][idx2];
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int dp[][] = new int[n1 + 1][n2 + 1];
        return minimum(n1, n2, word1, word2, dp);
    }
}