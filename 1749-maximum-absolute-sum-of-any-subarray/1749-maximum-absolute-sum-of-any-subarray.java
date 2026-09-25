class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currentMax=nums[0];
        int currentMin=nums[0];
        int maxSum=Math.abs(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(currentMax+nums[i]>nums[i]){
                currentMax+=nums[i];
            }
            else{
                currentMax=nums[i];
            }
            

            if(currentMin+nums[i]<nums[i]){
                currentMin+=nums[i];
            }
            else{
                currentMin=nums[i];
            }
            maxSum=Math.max(maxSum,Math.max(Math.abs(currentMax),Math.abs(currentMin)));
        }
        return maxSum;
    }
}