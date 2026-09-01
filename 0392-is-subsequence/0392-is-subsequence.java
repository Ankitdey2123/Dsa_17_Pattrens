class Solution {
    public boolean isSubsequence(String s, String t) {
        int l;
        int index=0;
        int count=0;
        if(s.length()==0){
            return true;
        }
        for(l=0;l<t.length();l++){
            char ch=t.charAt(l);
            if(index>=s.length()){
                break;
            }
            char n=s.charAt(index);
            if(ch==n){
                index++;
                count++;
            }
            if(count==s.length()){
                return true;
            }
        }
        return false;
    }
}