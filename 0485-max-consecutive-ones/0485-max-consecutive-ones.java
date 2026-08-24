class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0;
        int count=0,maxCount=Integer.MIN_VALUE;
        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        for(int right=0;right<nums.length;right++){
            if(nums[right]>0){
            if(map.containsKey(nums[right])){
                map.put(nums[right],map.get(nums[right])+1);
            }
            else{
                map.put(nums[right],1);
            }
            count++;
            }
            else{
                map.clear();
                count=0;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}