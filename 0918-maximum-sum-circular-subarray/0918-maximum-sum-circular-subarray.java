class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currentMax=nums[0];
        int currentMin=nums[0];
        int maxSum=nums[0];
        int minSum=nums[0];
        int total=0;
        for(int i:nums){
            total+=i;
        }
        for(int i=1;i<nums.length;i++){
            currentMax=Math.max(currentMax+nums[i],nums[i]);
            maxSum=Math.max(currentMax,maxSum);

            currentMin=Math.min(currentMin+nums[i],nums[i]);
            minSum=Math.min(currentMin,minSum);
        }
        if(maxSum<0){
            return maxSum;
        }
        int circleSum=total-minSum;
        maxSum=Math.max(maxSum,circleSum);

        return maxSum;
    }
}