class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer,Integer>map=new LinkedHashMap();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }
        for(int i=0;i<nums.length+1;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return -1;
    }
}