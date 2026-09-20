class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int range=Integer.MAX_VALUE;
        char ans=' ';
        int targetIndex=target-'a';
        for(int i=0;i<letters.length;i++){
            char c=letters[i];
            if(c==target){
                continue;
            }
            int l=c-'a';
            if(l>targetIndex && l<range){
                ans=c;
                range=l;
            }
        }
        if(ans==' '){
            ans=letters[0];
        }
        return ans;
    }
}