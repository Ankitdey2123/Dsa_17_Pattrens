class Solution {
    public int longestPalindrome(String s) {
     HashMap<Character,Integer>map=new LinkedHashMap<>();
     for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }
        else{
            map.put(ch,1);
        }
     }
     int len=0;
     boolean hasOdd=false;
     for(int i:map.values()){
        if(i%2==0){
            len+=i;
        }
        else{
            len=len+i-1;
            hasOdd=true;
        }
     }
     if(hasOdd){
        return len+1;
     }
     return len;
    }
}