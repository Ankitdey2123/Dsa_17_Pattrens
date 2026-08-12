class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int previousIn=map.get(nums[i]);
                int distance=i-previousIn;
                if(distance<=k){
                    return true;
                }

            }
            map.put(nums[i],i);
        }
        return false;
    }
}