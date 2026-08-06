class Solution {
    public List<String> commonChars(String[] words) {
        String first=words[0];
        int[] mainfre=new int[26];
        for(int i=0;i<first.length();i++){
            char ch=first.charAt(i);
            mainfre[ch-'a']++;
        }

        for(int i=1;i<words.length;i++){
            int[] temp=new int[26];
            first=words[i];
            for(int j=0;j<first.length();j++){
                char ch=first.charAt(j);
                temp[ch-'a']++;
            }
            for(int k=0;k<26;k++){
                mainfre[k]=Math.min(mainfre[k], temp[k]);
            }
        }
        List<String> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            while(mainfre[i]>0){
                ans.add(String.valueOf((char)(i+'a')));
                mainfre[i]--;
            }
        }
        return ans;
    }
}