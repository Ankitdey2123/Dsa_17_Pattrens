class Solution {
    public boolean isAnagram(String s, String t) {

        // Step 1: Length must be equal
        if (s.length() != t.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Step 2: Count frequency of first string
        for (int i = 0; i < s.length(); i++) {
            count1[s.charAt(i) - 'a']++;
        }

        // Step 3: Count frequency of second string
        for (int i = 0; i < t.length(); i++) {
            count2[t.charAt(i) - 'a']++;
        }

        // Step 4: Compare frequencies
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}