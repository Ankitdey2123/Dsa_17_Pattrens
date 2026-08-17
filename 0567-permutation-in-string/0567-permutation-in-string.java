class Solution {
    public boolean checkInclusion(String s1, String s2) {
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        HashMap<Character,Integer>str1=new LinkedHashMap<>();
        HashMap<Character,Integer>str2=new LinkedHashMap<>();
        if(s1.length()>s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            if(str1.containsKey(ch)){
                str1.put(ch,str1.get(ch)+1);
            }
            else{
                str1.put(ch,1);
            }
        }
        int k=s1.length();
        
        for(int i=0;i<k;i++){
            char ch=s2.charAt(i);
            if(str2.containsKey(ch)){
                str2.put(ch,str2.get(ch)+1);
            }
            else{
                str2.put(ch,1);
            }
        }
        if(str1.equals(str2)){
            return true;
        }
        for(int i=k;i<s2.length();i++){
            char remove=s2.charAt(i-k);
            if(str2.get(remove)==1){
                str2.remove(remove);
            }
            else{
                str2.put(remove,str2.get(remove)-1);
            }
            char add=s2.charAt(i);
            if(str2.containsKey(add)){
                str2.put(add,str2.get(add)+1);
            }
            else{
                str2.put(add,1);
            }
            if(str2.equals(str1)){
                return true;
            }
        }
        return false;
    }
}