class Solution {
    public int maxProduct(int[] nums) {
       if(nums.length==1)return nums[0];
       int maxpro = nums[0];
       int minpro = nums[0];
       int result = nums[0];
       for(int i=1;i<nums.length;i++){
        if(nums[i]<0){
            int temp = maxpro;
             maxpro = minpro;
             minpro = temp;
        }
        maxpro = Math.max(nums[i],maxpro*nums[i]);
        minpro = Math.min(nums[i],minpro*nums[i]);
        result = Math.max(result,maxpro);
      }
       return result; 
    }
}