class Solution {
    public int missingMultiple(int[] nums, int k) {
        int count=1;
        HashSet<Integer>set=new LinkedHashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i=count;i<Integer.MAX_VALUE;i++){
            if(!set.contains(k*i)){
                int mis=k*i;
                return mis;
            }
        }
        return 0;
        
    }
}