class Solution {
    public int[] leftRightDifference(int[] nums) {
        int totalSum=0;
        for(int i:nums){
            totalSum+=i;
        }
        int leftSum=0;
        int rightSum;
        int[] ans=new int[nums.length];
                if(nums.length==1){
            return ans;
        }
        for(int i=0;i<nums.length;i++){
            rightSum=totalSum-leftSum-nums[i];
            int diff=Math.abs(leftSum-rightSum);
            ans[i]=diff;
            leftSum=leftSum+nums[i];
        }
        return ans;
    }
}