class Solution {
    public void moveZeroes(int[] nums) {
     int left=0;
    for(int right=0;right<nums.length;right++){
        int temp=0;
        if(nums[right]!=0){
        if(left!=right){
            temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        left++;
        }
    }
    for(int i:nums){
        System.out.println(i);
    }   
    }
}