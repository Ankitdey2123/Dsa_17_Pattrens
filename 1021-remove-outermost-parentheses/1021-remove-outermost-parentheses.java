class Solution {
    public String removeOuterParentheses(String s) {
               String result = "";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (count > 0) {
                    result += s.charAt(i);
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    result += s.charAt(i);
                }
            }
        }

        return result; 
    }
}