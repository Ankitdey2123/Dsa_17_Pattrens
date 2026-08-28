class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check if a palindrome can be formed
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String targetHalf = target.substring(0, halfLen);

        // First try to construct exactly targetHalf
        String half = buildExact(targetHalf, halfFreq);

        if (half != null) {
            String palindrome = makePalindrome(half, middle, n);

            // This is important:
            // Even if the first half is equal to target's first half,
            // the complete palindrome might already be greater.
            if (palindrome.compareTo(target) > 0) {
                return palindrome;
            }
        }

        // Exact half didn't work, so find the next greater half
        half = buildNextGreater(targetHalf, halfFreq);

        if (half == null) {
            return "";
        }

        return makePalindrome(half, middle, n);
    }

    private String buildExact(String targetHalf, int[] freq) {
        int[] remaining = freq.clone();
        StringBuilder result = new StringBuilder();

        for (char ch : targetHalf.toCharArray()) {
            int c = ch - 'a';

            if (remaining[c] == 0) {
                return null;
            }

            result.append(ch);
            remaining[c]--;
        }

        return result.toString();
    }

    private String buildNextGreater(String targetHalf, int[] freq) {
        int n = targetHalf.length();

        // Try changing from right to left.
        for (int pos = n - 1; pos >= 0; pos--) {

            int[] remaining = freq.clone();
            StringBuilder prefix = new StringBuilder();

            // Match everything before pos
            boolean possible = true;

            for (int i = 0; i < pos; i++) {
                int c = targetHalf.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                prefix.append(targetHalf.charAt(i));
                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            int current = targetHalf.charAt(pos) - 'a';

            // Put the smallest character greater than target[pos]
            for (int c = current + 1; c < 26; c++) {

                if (remaining[c] > 0) {
                    StringBuilder result = new StringBuilder(prefix);

                    result.append((char) ('a' + c));
                    remaining[c]--;

                    // Fill the rest with smallest characters
                    for (int k = 0; k < 26; k++) {
                        while (remaining[k] > 0) {
                            result.append((char) ('a' + k));
                            remaining[k]--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        return null;
    }

    private String makePalindrome(String half, char middle, int n) {
        StringBuilder result = new StringBuilder();

        result.append(half);

        if (n % 2 == 1) {
            result.append(middle);
        }

        for (int i = half.length() - 1; i >= 0; i--) {
            result.append(half.charAt(i));
        }

        return result.toString();
    }
}