class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map=new LinkedHashMap<>();
        int left=0;
        int maxCount=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            while(map.containsKey(ch)){
                char rm=s.charAt(left);
                if(map.get(rm)==1){
                    map.remove(rm);
                }
                else{
                    map.put(rm,map.get(rm)-1);
                }
                left++;
            }
            map.put(ch,1);
            if(map.size()>maxCount){
                maxCount=map.size();
            }
        }
        return maxCount;
        
    }
}