class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer>map=new LinkedHashMap();
        for(int i:nums){
            if(map.containsKey(i)){
                return true;
            }
            else{
                map.put(i,1);
            }
        }
        return false;
        
    }
}