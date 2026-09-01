class Solution {
    public int strStr(String haystack, String needle) {
        int count=needle.length();
        int index=0;
        int l=0;
        int r=0;
        while(r<haystack.length()){
            char ch=haystack.charAt(r);
            char ne=needle.charAt(index);
            if(ch!=ne){
                l++;;
                r=l;
                count=needle.length();
                index=0;
            }
            else
            {
                count--;
                index++;
                r++;
            }
            if(count==0){
                return l;
            }
        }
        if(count>0){
            return -1;
        }
        return -1;
    }
}