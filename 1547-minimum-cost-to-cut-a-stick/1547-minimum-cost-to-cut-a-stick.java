class Solution {

    public int MinCostToCut(int i,int j,int arr[],int dp[][]){
      if(i>j) return 0;
      if(dp[i][j]!=-1)return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost = arr[j+1]-arr[i-1] +MinCostToCut(i,k-1,arr,dp)+MinCostToCut(k+1,j,arr,dp);
            if(cost<min){
                min = cost;
            }
        }
        return dp[i][j] = min;
    }
    public int minCost(int n, int[] cuts) {
        int new_arr[] = new int[cuts.length+2];
        int n1 = cuts.length;
        int n2 = new_arr.length;
        new_arr[0] =0;
        for(int i=0;i<cuts.length;i++){
            new_arr[i+1] = cuts[i];
        }
        new_arr[new_arr.length-1] = n;
        Arrays.sort(new_arr);
        int dp[][] = new int[n1+1][n1+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return MinCostToCut(1,new_arr.length-2,new_arr,dp);

    }
}