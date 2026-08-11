class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>n){
                n=nums[i];
            }
        }
        int min=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        HashSet<Integer>set=new LinkedHashSet<>();
        ArrayList<Integer>mis = new ArrayList<>(); 
        for(int i=0;i<nums.length;i++){
          set.add(nums[i]);  
        }
        for(int i=min;i<n;i++){
            if(!set.contains(i)){
                mis.add(i);
            }
        }
        return mis; 
    }
}