class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit =Integer.MIN_VALUE;
        int  minStock =Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
          minStock = Math.min(minStock,prices[i]);
          maxProfit = Math.max(maxProfit,prices[i]-minStock);
        }
        return maxProfit;
    }
}