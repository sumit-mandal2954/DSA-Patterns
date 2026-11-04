class Solution {
    public int DS(int idx1, int idx2, String s, String t,int dp[][]) {
        if(idx2<0)return 1;
        if (idx1 < 0) return 0;

        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        if (s.charAt(idx1) == t.charAt(idx2)) {
            dp[idx1][idx2] =  DS(idx1 - 1, idx2 - 1, s, t,dp) + DS(idx1 - 1, idx2, s, t,dp);
        } else {
           dp[idx1][idx2]=   DS(idx1 - 1, idx2,s,t,dp);
        }
        return dp[idx1][idx2];
    }

    public int numDistinct(String s, String t) {
      int n1 = s.length();
      int n2 = t.length();
      int dp[][] = new int[n1][n2];
      for(int i=0;i<dp.length;i++){
        Arrays.fill(dp[i],-1);
      }
      return DS(n1-1,n2-1,s,t,dp);
    }
}