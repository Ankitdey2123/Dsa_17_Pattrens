class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character>set=new LinkedHashSet<>();
        int maxVowel=0;
        int windowVowel=0;
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                windowVowel++;
                set.add(ch);
            }
        }
        maxVowel=windowVowel;
        for(int i=k;i<s.length();i++){
            char ch=s.charAt(i);
            char remove=s.charAt(i-k);
            if(remove=='a'|| remove=='e' || remove=='i' || remove=='o' || remove=='u'){
              set.remove(remove);
              windowVowel--;
            }
            if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                set.add(ch);
                windowVowel++;
            }
            if(windowVowel>maxVowel){
                maxVowel=windowVowel;
            }
        }
        return maxVowel;
        
    }
}