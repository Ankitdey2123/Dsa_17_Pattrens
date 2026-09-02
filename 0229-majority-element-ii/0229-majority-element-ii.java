class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer>list=new ArrayList<>();
        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],0);
            }
        }
        int n=nums.length;
        if(n==1){
            list.add(nums[0]);
            return list;
        }
        for(int i:map.keySet()){
            int m=map.get(i);
            if(m>=n/3){
                list.add(i);
            }
        }
        return list;
    }
}