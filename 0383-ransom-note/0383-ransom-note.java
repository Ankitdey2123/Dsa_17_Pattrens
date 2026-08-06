class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count1=new int[26];
        int[] count2=new int[26];
        for(int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            count1[ch-'a']++;
        }
        for(int i=0;i<magazine.length();i++){
            char ch=magazine.charAt(i);
            count2[ch-'a']++;
        }
        for(int i=0;i<26;i++){
        
                if(count2[i]<count1[i]){
                    return false;
                }
        }
        return true;
    }
}