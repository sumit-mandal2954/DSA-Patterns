class Solution {
    public int LCS(int idx1,int idx2,String s1,String s2,int dp[][]){
        for(int i=0;i<=s1.length();i++){
            dp[i][0] =0;
        }
        for(int j=0;j<=s2.length();j++){
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
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int dp[][] = new int[n1+1][n2+1];
        StringBuilder sb = new StringBuilder();
        LCS(n1,n2,str1,str2,dp);
        int i=n1;
        int j = n2;
        while(i>0&&j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
      while(i>0){
        sb.append(str1.charAt(i-1));
        i--;
      }
      while(j>0){
        sb.append(str2.charAt(j-1));
        j--;
      }
        return sb.reverse().toString();
    }
}