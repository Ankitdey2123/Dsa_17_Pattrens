class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(s, 0, 0, new char[]{'(', ')'}, result);
        return result;
    }

    private void remove(String s, int start, int last, char[] pair, List<String> result) {
        int count = 0;

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) {
                count++;
            } else if (s.charAt(i) == pair[1]) {
                count--;
            }

            if (count >= 0) {
                continue;
            }

            for (int j = last; j <= i; j++) {
                if (s.charAt(j) == pair[1] &&
                    (j == last || s.charAt(j - 1) != pair[1])) {

                    remove(
                        s.substring(0, j) + s.substring(j + 1),
                        i,
                        j,
                        pair,
                        result
                    );
                }
            }

            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();

        if (pair[0] == '(') {
            remove(reversed, 0, 0, new char[]{')', '('}, result);
        } else {
            result.add(reversed);
        }
    }
}