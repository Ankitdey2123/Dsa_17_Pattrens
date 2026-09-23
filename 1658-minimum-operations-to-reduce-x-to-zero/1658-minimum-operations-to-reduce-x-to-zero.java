class Solution {
    public int minOperations(int[] nums, int x) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        int target=total-x;
        if(target<0){
            return -1;
        }
        int l=0;
        int sum=0;
        int longest=-1;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>target){
                sum-=nums[l];
                l++;
            }
            if(sum==target){
                int clongest=r-l+1;
                if(clongest>longest){
                    longest=clongest;
                }
            }
        }
        if(longest==-1){
            return -1;
        }
        int res=nums.length-longest;
        return res;
    }
}