class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new LinkedHashSet();
        for(int i:nums){
            set.add(i);
        }
        int longest=0;
        for(int i:set){
            if(!set.contains(i-1)){
                int current=i;
                int count =1;
                while(set.contains(current+1)){
                    count++;
                    current++;

                }
                longest=Math.max(longest,count);
            }
        }
          return longest;
    }
}