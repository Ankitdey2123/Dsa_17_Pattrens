class Solution {
    public char findTheDifference(String s, String t) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            count1[ch1 - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch2 = t.charAt(i);
            count2[ch2 - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(count2[i]!=count1[i]){
                return (char)(i+'a');
            }
        }
        return ' ';  
    }

}