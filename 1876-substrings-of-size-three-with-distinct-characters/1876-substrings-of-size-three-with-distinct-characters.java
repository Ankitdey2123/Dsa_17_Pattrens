class Solution {
    public int countGoodSubstrings(String s) {
        int k=3;
        if(s.length()<k){
            return 0;
        }
        HashMap<Character,Integer>map=new LinkedHashMap<>();
        int maxCount=0;
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        if(map.size()==3){
            maxCount++;
        }
        for(int i=k;i<s.length();i++){
            char rm=s.charAt(i-k);
            if(map.get(rm)==1){
                map.remove(rm);
            }
            else{
                map.put(rm,map.get(rm)-1);
            }
            char add=s.charAt(i);
            if(map.containsKey(add)){
                map.put(add,map.get(add)+1);
            }
            else{
                map.put(add,1);
            }
            if(map.size()==k){
                maxCount++;
            }
        }
        return maxCount;
    }
}