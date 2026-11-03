// class Solution {
//     public int LCS(int idx1,int idx2,String s1,String s2,int dp[][]){
//         if(idx1<0||idx2<0) return 0;
        
//         if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
//         int match =0;
//         int notMatch =0;
//         if(s1.charAt(idx1)==s2.charAt(idx2)){
//             match = 1+ LCS(idx1-1,idx2-1,s1,s2,dp);
//         }else{
//             notMatch = 0+ Math.max(LCS(idx1-1,idx2,s1,s2,dp),LCS(idx1,idx2-1,s1,s2,dp));
//         }
//         return dp[idx1][idx2] =  Math.max(match,notMatch);
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n1 = text1.length();
//         int n2 = text2.length();
//         int dp[][] = new int[n1+1][n2+1];
//         for(int i=0;i<dp.length;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return LCS(n1-1,n2-1,text1,text2,dp);
//     }
// }



//tbulation


class Solution {
    public int LCS(int idx1,int idx2,String s1,String s2,int dp[][]){
      
        if(idx1==0||idx2==0) return 0;
        
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        int match =0;
        int notMatch =0;
        if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){
            match = 1+ LCS(idx1-1,idx2-1,s1,s2,dp);
        }else{
            notMatch = 0+ Math.max(LCS(idx1-1,idx2,s1,s2,dp),LCS(idx1,idx2-1,s1,s2,dp));
        }
        return dp[idx1][idx2] =  Math.max(match,notMatch);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return LCS(n1,n2,text1,text2,dp);
    }
}