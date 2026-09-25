class Solution {
  public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, new int[]{0});
        return new ArrayList<>(new TreeSet<>(result));
    }

    private Set<String> parse(String s, int[] index) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (index[0] < s.length() && s.charAt(index[0]) != '}') {

            char ch = s.charAt(index[0]);

            // Union
            if (ch == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                index[0]++;
            }

            // Braced expression
            else if (ch == '{') {
                index[0]++;

                Set<String> inside = parse(s, index);

                // Skip '}'
                index[0]++;

                current = concatenate(current, inside);
            }

            // Single letter
            else {
                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(ch));

                current = concatenate(current, letter);
                index[0]++;
            }
        }

        result.addAll(current);

        return result;
    }

    private Set<String> concatenate(Set<String> first, Set<String> second) {
        Set<String> result = new HashSet<>();

        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }

        return result;
    }
}