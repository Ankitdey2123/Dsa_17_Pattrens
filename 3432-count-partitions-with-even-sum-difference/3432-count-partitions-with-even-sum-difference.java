class Solution {
    public int countPartitions(int[] nums) {
        int leftsum=0;
      
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            leftsum+=nums[i];
              int rightsum=0;
            for(int j=i+1;j<nums.length;j++){
                rightsum+=nums[j];
            }
            if(Math.abs(leftsum-rightsum)%2==0){
                count++;
            }
        }
        return count;
    }
}