class Solution {
    public int findLHS(int[] nums) {
        int output=0;
        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }
        for(int i:map.keySet()){
            if(map.containsKey(i+1)){
                int sum=map.get(i)+map.get(i+1);
                output=Math.max(output,sum);
            }
        }
        return output;
    }
}