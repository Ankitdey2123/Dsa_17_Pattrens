class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i, 1);
            }
        }
        for(int i:map.keySet()){
            if(map.get(i)>n/2){
                return i;
            }
        }
        return ' ';
    }
}