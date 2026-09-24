class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
 HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String current = strs[i];

            char[] ch = current.toCharArray();

            Arrays.sort(ch);

            String key = new String(ch);

            if (map.containsKey(key)) {
                map.get(key).add(current);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(current);
            }
        }

        return new ArrayList<>(map.values());
    }
}