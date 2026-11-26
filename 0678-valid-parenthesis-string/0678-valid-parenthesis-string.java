class Solution {

    public static boolean Validation(int idx, int cut, String s,int dp[][]) {
        if (cut < 0)
            return false;
        if (idx < 0) {
            return cut == 0;
        }
        if(dp[idx][cut]!=-1)return dp[idx][cut]==1;
        boolean ans =false;
        if (s.charAt(idx) == '(') {
            ans= Validation(idx - 1, cut - 1, s,dp);
        } else if (s.charAt(idx) == ')') {
            ans =  Validation(idx - 1, cut + 1, s,dp);
        } else {
            ans = Validation(idx - 1, cut + 1, s,dp) || Validation(idx - 1, cut - 1, s,dp) || Validation(idx - 1, cut, s,dp);
        }
         dp[idx][cut] = ans?1:0;
        return ans;
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return Validation(s.length() - 1, 0, s,dp);
    }
}