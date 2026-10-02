class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        generate("", 0, 0, n, ans);

        return ans;
    }

    public void generate(String current, int open, int close, int n, List<String> ans) {

        // If we used all pairs
        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        // We can add '(' if we still have opening brackets
        if (open < n) {
            generate(current + "(", open + 1, close, n, ans);
        }

        // We can add ')' only if there is an unmatched '('
        if (close < open) {
            generate(current + ")", open, close + 1, n, ans);
        }
    }
}