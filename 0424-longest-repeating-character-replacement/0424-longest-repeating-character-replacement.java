class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>map=new LinkedHashMap<>();
        int left=0;
        int maxLength=0;
        int maxValue=Integer.MIN_VALUE;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
            int wlength=right-left+1;
            int maxFrequency=0;
            for(int i:map.values()){
                maxFrequency=Math.max(maxFrequency,i);
            }
            while((wlength-maxFrequency)>k){
                char rm=s.charAt(left);
                if(map.get(rm)==1){
                    map.remove(rm);
                }
                else{
                    map.put(rm,map.get(rm)-1);
                }
                 left++;
                wlength=right-left+1;
                maxFrequency=0;
                for(int i:map.values()){
                    maxFrequency=Math.max(maxFrequency,i);
                }
            }
            maxLength=Math.max(maxLength,wlength);
        }
        return maxLength;
    }
}