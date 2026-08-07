class Solution {
    public boolean isAnagram(String s, String t) {

       HashMap<Character, Integer> map1 = new LinkedHashMap<>();
        HashMap<Character, Integer> map2 = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) + 1);
            } else {
                map1.put(ch, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map2.containsKey(ch)) {
                map2.put(ch, map2.get(ch) + 1);
            } else {
                map2.put(ch, 1);
            }
        }
        if(map1.equals(map2)){
            return true;
        }
        else{
            return false;
        }
    }
}