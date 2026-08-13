class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum=0;
        long windowSum=0;
        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        for(int i=0;i<k;i++){
            windowSum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.size()==k){
            maxSum=windowSum;
        }
        for(int i=k;i<nums.length;i++){
            map.put(nums[i-k],map.get(nums[i-k])-1);
            if(map.get(nums[i-k])==0){
                map.remove(nums[i-k]);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            windowSum=windowSum-nums[i-k]+nums[i];
            if(map.size()==k){
                if(windowSum>maxSum){
                maxSum=windowSum;
                }
            }
        }
        return maxSum;
    }
}