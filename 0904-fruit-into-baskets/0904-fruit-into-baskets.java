class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        int left = 0;
        int count = 0;
        int maxCount = 0;
        for (int right = 0; right < fruits.length; right++) {
            if (map.containsKey(fruits[right])) {
                map.put(fruits[right], map.get(fruits[right]) + 1);
            } else {
                map.put(fruits[right], 1);
            }
            while (map.size() > 2) {
                if (map.get(fruits[left]) == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                }
                left++;
            }
            count = right - left + 1;
            maxCount = Math.max(maxCount, count);

        }
        return maxCount;
    }
}