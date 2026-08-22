class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int sum=0;
        int minCount=Integer.MAX_VALUE;
        int count=0;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>=target){
                count=right-left+1;
                minCount=Math.min(minCount,count);
                  sum-=nums[left];
                left++;
            }
            right++;
        }
        if(minCount==Integer.MAX_VALUE){
            minCount=0;
        }
        return minCount;
    }
}