class Solution {
    public int findMiddleIndex(int[] nums) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        int leftSum=0;
        int rightSum;
        for(int i=0;i<nums.length;i++){
            rightSum=total-leftSum-nums[i];
            if(leftSum==rightSum){
                return i;
            }
            leftSum=leftSum+nums[i];
        }
        return -1;
    }
}