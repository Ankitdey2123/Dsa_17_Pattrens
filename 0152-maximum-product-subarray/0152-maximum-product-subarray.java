class Solution {
    public int maxProduct(int[] nums) {
        int currentMax=nums[0];
        int currentMin=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            int oldMax=currentMax;
            int oldMin=currentMin;
            currentMax=Math.max(nums[i],Math.max(oldMax*nums[i],oldMin*nums[i]));
            currentMin=Math.min(nums[i],Math.min(oldMax*nums[i],oldMin*nums[i]));

            if(currentMax>maxSum){
                maxSum=currentMax;
            }
        }
        return maxSum;
    }   
}