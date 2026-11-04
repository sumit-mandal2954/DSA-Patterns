class Solution {
    public int LPS(int idx1,int idx2,String s1,String s2,int dp[][]){
        for(int i=0;i<=s1.length();i++){
            dp[i][0] =0;
        }
         for(int j=0;j<=s1.length();j++){
            dp[0][j] =0;
        }

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
              if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j] = 1+dp[i-1][j-1];
              }else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
              }
            }
        }
        return dp[idx1][idx2];
    }
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        int n1 = s.length();
        int dp[][] = new int[n1+1][n1+1];
        int lps = LPS(n1,n1,s,s2,dp);
        return s.length()-lps;
    }
}