class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer>set=new LinkedHashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int index=0;
        for(int i:set){
            nums[index]=i;
            index++;
        }
        int count=set.size();
        return count;
        
    }
}