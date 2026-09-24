class Solution {
    public int findPeakElement(int[] nums) {
        int index=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                index=i;
                max=nums[i];
            }
        }
        return index;
    }
}