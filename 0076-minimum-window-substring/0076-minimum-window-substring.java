class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int l = 0;
        int count = 0;
        int current = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = t.length();
        int start = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    n--;
                }
                map.put(ch, map.get(ch) - 1);
            }
            while (n == 0) {
                current = r - l + 1;
                if (current < count || count == 0) {
                    count = current;
                    start = l;
                }
                char ch1 = s.charAt(l);
                if (map.containsKey(ch1)) {
                    if (map.get(ch1) >= 0) {
                        n++;
                    }
                    map.put(ch1, map.get(ch1) + 1);
                }
                l++;
            }
        }
        if (count == 0) {
            return "";
        }
        return s.substring(start, start + count);
    }
}