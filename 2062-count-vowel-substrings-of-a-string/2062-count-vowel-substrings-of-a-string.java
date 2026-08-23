class Solution {
    public int countVowelSubstrings(String word) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        int left = 0;
        int count = 0;
        for (int right = 0; right < word.length(); right++) {
            char ch = word.charAt(right);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                map.put(ch, right);

                if (map.size() == 5) {

                    int minIndex = Math.min(
                            map.get('a'),
                            Math.min(
                                    map.get('e'),
                                    Math.min(
                                            map.get('i'),
                                            Math.min(map.get('o'), map.get('u')))));

                    count = count + (minIndex - left + 1);
                }
            } else {
                map.clear();
                left = right + 1;
            }
        }
        return count;
    }
}